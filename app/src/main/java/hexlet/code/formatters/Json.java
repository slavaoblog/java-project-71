package hexlet.code.formatters;

import hexlet.code.Node;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;

public class Json {
    public static String format(List<Node> differences) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(differences);
    }
}
