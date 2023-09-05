package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Stylish {
    public static String format(List<Node> differences) {
        StringBuilder result = new StringBuilder("{\n");

        for (Node element : differences) {
            String key = element.getKey();
            String typeOfChange = element.getTypeOfChange();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();
            switch (typeOfChange) {
                case "added":
                    result.append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                case "deleted":
                    result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(key).append(": ").append(oldValue).append("\n");
                    break;
                case "changed":
                    result.append("  - ").append(key).append(": ").append(oldValue).append("\n")
                            .append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                default:
                    break;
            }
        }
        result.append("}");
        return result.toString();
    }
}
