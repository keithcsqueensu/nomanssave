package nomanssave.facade;

import java.util.Objects;
import nomanssave.fn;
import nomanssave.fs;

public final class SaveFileEntry {
    private final fs delegate;

    private SaveFileEntry(fs delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static SaveFileEntry wrap(fs delegate) {
        return delegate == null ? null : new SaveFileEntry(delegate);
    }

    public fs unwrap() {
        return delegate;
    }

    /** Underlying filename / identifier (fs.K()). */
    public String id() {
        return delegate.K();
    }

    public fn mode() {
        return delegate.L();
    }

    public JsonObject load() {
        return JsonObject.wrap(delegate.M());
    }

    /** Writes JSON back to this save file (fs.b(eY)). */
    public String write(JsonObject obj) {
        Objects.requireNonNull(obj, "obj");
        return delegate.b(obj.unwrap());
    }

    public long lastModifiedMillis() {
        return delegate.lastModified();
    }

    public String displayName() {
        return delegate.getName();
    }

    public String description() {
        return delegate.getDescription();
    }
}