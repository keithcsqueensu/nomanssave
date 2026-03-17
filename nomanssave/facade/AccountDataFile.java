package nomanssave.facade;

import java.util.Objects;
import nomanssave.fr;

public final class AccountDataFile {
    private final fr delegate;

    private AccountDataFile(fr delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static AccountDataFile wrap(fr delegate) {
        return delegate == null ? null : new AccountDataFile(delegate);
    }

    public fr unwrap() {
        return delegate;
    }

    /** Underlying filename / identifier (fr.K()). */
    public String id() {
        return delegate.K();
    }

    public JsonObject load() {
        return JsonObject.wrap(delegate.M());
    }

    public void write(JsonObject obj) {
        Objects.requireNonNull(obj, "obj");
        delegate.k(obj.unwrap());
    }
}