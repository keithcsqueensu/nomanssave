package nomanssave.facade;

import java.io.File;
import java.util.Objects;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.fe;

public final class JsonObject {
    private final eY delegate;

    private JsonObject(eY delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static JsonObject wrap(eY delegate) {
        return delegate == null ? null : new JsonObject(delegate);
    }

    public eY unwrap() {
        return delegate;
    }

    public String toPrettyString() {
        return delegate.bz();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    public Object getPath(String path) {
        return delegate.getValue(path);
    }

    public JsonObject getObject(String path) {
        return wrap(delegate.H(path));
    }

    public JsonArray getArray(String path) {
        return JsonArray.wrap(delegate.d(path));
    }

    public String getString(String path) {
        return delegate.getValueAsString(path);
    }

    public int getInt(String path) {
        return delegate.J(path);
    }

    public long getLong(String path) {
        return delegate.K(path);
    }

    public double getDouble(String path) {
        return delegate.L(path);
    }

    public boolean getBoolean(String path) {
        return delegate.M(path);
    }

    /** Delegate to eY.b(path, value). */
    public Object setPath(String path, Object value) {
        return delegate.b(path, value);
    }

    /** Delegate to eY.c(path, value) (alternate semantics). */
    public Object setPathForce(String path, Object value) {
        return delegate.c(path, value);
    }

    public void writeTo(File file) {
        delegate.c(file);
    }

    public void readFrom(File file) {
        delegate.d(file);
    }

    public JsonObject deepCopy() {
        return wrap(delegate.bE());
    }

    public void setChangeListener(JsonChangeListener listener) {
        if (listener == null) {
            delegate.a((fe) null);
            return;
        }
        delegate.a(new fe() {
            @Override
            public void propertyChanged(String var1, Object var2, Object var3) {
                listener.propertyChanged(var1, var2, var3);
            }
        });
    }
}