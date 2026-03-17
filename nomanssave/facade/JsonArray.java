package nomanssave.facade;

import java.util.Objects;
import java.util.stream.Stream;
import nomanssave.eV;
import nomanssave.eY;

public final class JsonArray {
    private final eV delegate;

    private JsonArray(eV delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    public static JsonArray wrap(eV delegate) {
        return delegate == null ? null : new JsonArray(delegate);
    }

    public eV unwrap() {
        return delegate;
    }

    public int size() {
        return delegate.size();
    }

    public Object get(int index) {
        return delegate.get(index);
    }

    public JsonObject getObject(int index) {
        return JsonObject.wrap(delegate.V(index));
    }

    public JsonArray getArray(int index) {
        return wrap(delegate.W(index));
    }

    public String getString(int index) {
        return delegate.X(index);
    }

    public int getInt(int index) {
        return delegate.Y(index);
    }

    public long getLong(int index) {
        return delegate.Z(index);
    }

    public double getDouble(int index) {
        return delegate.aa(index);
    }

    public boolean getBoolean(int index) {
        return delegate.ab(index);
    }

    public void add(Object value) {
        delegate.add(value);
    }

    public Object set(int index, Object value) {
        return delegate.set(index, value);
    }

    public Object remove(int index) {
        return delegate.remove(index);
    }

    public JsonArray deepCopy() {
        return wrap(delegate.bA());
    }

    /** Stream of elements that are JsonObjects (matches eV.bB()) */
    public Stream<JsonObject> objectStream() {
        @SuppressWarnings("unchecked")
        Stream<eY> s = delegate.bB();
        return s.map(JsonObject::wrap);
    }
}