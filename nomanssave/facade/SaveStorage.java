package nomanssave.facade;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nomanssave.eY;
import nomanssave.fR;
import nomanssave.fq;
import nomanssave.fr;
import nomanssave.ft;

public final class SaveStorage {
    private final fq delegate;

    private SaveStorage(fq delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static SaveStorage wrap(fq delegate) {
        return delegate == null ? null : new SaveStorage(delegate);
    }

    public static SaveStorage detect(File pathOrFile, fR watcher) {
        return wrap(fq.a(pathOrFile, watcher));
    }

    public static SaveStorage fromTypeName(String storageName, File dir, fR watcher) {
        return wrap(fq.a(storageName, dir, watcher));
    }

    public fq unwrap() {
        return delegate;
    }

    public File rootDir() {
        return delegate.bS();
    }

    public fr accountData() {
        return delegate.bT();
    }

    public List<GameSlot> slots(boolean includeEmpty) {
        ft[] raw = includeEmpty ? delegate.bU() : delegate.bV();
        return Arrays.stream(raw).map(GameSlot::wrap).collect(Collectors.toList());
    }

    public int slotIndexForFilename(String filename) {
        return delegate.W(filename);
    }

    public boolean supportsSaveAs() {
        return delegate.bW();
    }

    /** Create/copy a slot save; may throw if unsupported. */
    public String createSlotSave(int slotIndex, JsonObject saveJson) {
        Objects.requireNonNull(saveJson, "saveJson");
        return delegate.a(slotIndex, saveJson.unwrap());
    }
}