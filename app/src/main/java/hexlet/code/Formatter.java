package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Node> differences, String format) throws Exception {
        switch (format) {
            case "plain":
                return Plain.format(differences);
            case "stylish":
                return Stylish.format(differences);
            case "json":
                return Json.format(differences);
            default:
                var message = String.format("Unknown format name: %s. Can be 'stylish', 'plain' or 'json'", format);
                throw new Exception(message);
        }
    }
}
