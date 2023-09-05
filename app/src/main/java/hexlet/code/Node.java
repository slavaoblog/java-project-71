package hexlet.code;

public class Node {
    private final String typeOfChange;
    private final String key;
    private final Object oldValue;
    private final Object newValue;

    public Node(String typeOfChange, String key, Object oldValue, Object newValue) {
        this.typeOfChange = typeOfChange;
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public final String getTypeOfChange() {
        return typeOfChange;
    }

    public final String getKey() {
        return key;
    }

    public final Object getOldValue() {
        return oldValue;
    }

    public final Object getNewValue() {
        return newValue;
    }
}
