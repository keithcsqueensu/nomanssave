package nomanssave.facade;

import java.util.Objects;
import nomanssave.fn;

public final class GameMode {
    private final fn delegate;

    private GameMode(fn delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static GameMode wrap(fn delegate) {
        return delegate == null ? null : new GameMode(delegate);
    }

    public fn unwrap() {
        return delegate;
    }

    public static GameMode fromSave(JsonObject saveRoot) {
        Objects.requireNonNull(saveRoot, "saveRoot");
        return wrap(fn.i(saveRoot.unwrap()));
    }

    public static GameMode fromJsonText(String jsonText) {
        return wrap(fn.T(jsonText));
    }

    @Override
    public String toString() {
        return delegate.name();
    }
}