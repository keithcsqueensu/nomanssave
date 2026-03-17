package nomanssave.facade;

@FunctionalInterface
public interface JsonChangeListener {
    void propertyChanged(String path, Object oldValue, Object newValue);
}