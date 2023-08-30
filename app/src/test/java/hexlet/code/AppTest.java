package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class AppTest {
    private final String filepath1Json = ("src/test/resources/file1.jsn");
    private final String filepath2Json = ("src/test/resources/file2.jsn");

    @Test
    void testGetData() throws Exception {
        Path path = Paths.get(filepath1Json);
        HashMap map = Differ.getData(path);

        assertThat(map.containsKey("follow")).isTrue();
        assertThat(map.get("host")).isEqualTo("hexlet.io");
    }

    @Test
    void testGenerate() throws Exception {
        String actual = Differ.generate(filepath1Json, filepath2Json);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_json.jsn"));
        assertThat(actual).isEqualTo(expected);
    }
}
