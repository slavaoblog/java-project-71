package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Plain {
    public static String format(List<Node> differences) {
        StringBuilder result = new StringBuilder();

        for (Node element : differences) {
            String key = element.getKey();
            String typeOfChange = element.getTypeOfChange();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();
            switch (typeOfChange) {
                case "added":
                    result.append("Property '").append(key).append("' was added with value: ")
                            .append(getValue(newValue)).append("\n");
                    break;
                case "deleted":
                    result.append("Property '").append(key).append("' was removed\n");
                    break;
                case "changed":
                    result.append("Property '").append(key).append("' was updated. From ").append(getValue(oldValue))
                            .append(" to ").append(getValue(newValue)).append("\n");
                    break;
                default:
                    break;
            }
        }
        return result.toString().trim();
    }
    private static String getValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        } else if (!(value instanceof Integer) && !(value instanceof Boolean)) {
            return "[complex value]";
        }
        return value.toString();
    }
}
