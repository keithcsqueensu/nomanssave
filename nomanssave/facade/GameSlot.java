package nomanssave.facade;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nomanssave.fn;
import nomanssave.ft;

public final class GameSlot {
    private final ft delegate;

    private GameSlot(ft delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static GameSlot wrap(ft delegate) {
        return delegate == null ? null : new GameSlot(delegate);
    }

    public ft unwrap() {
        return delegate;
    }

    public int index() {
        return delegate.getIndex();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public fn mode() {
        return delegate.L();
    }

    public List<SaveFileEntry> saveFiles() {
        return Arrays.stream(delegate.bX())
                .map(SaveFileEntry::wrap)
                .collect(Collectors.toList());
    }
}