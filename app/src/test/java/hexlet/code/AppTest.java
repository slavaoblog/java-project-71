package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {
    private final String filepath1Json = ("src/test/resources/file1.jsn");
    private final String filepath2Json = ("src/test/resources/file2.jsn");
    private final String filepath1Yaml = ("src/test/resources/file1.yml");
    private final String filepath2Yaml = ("src/test/resources/file2.yml");

    @Test
    void testStylishJson() throws Exception {
        String actual = Differ.generate(filepath1Json, filepath2Json);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_json.jsn"));
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void testPlainYaml() throws Exception {
        String actual = Differ.generate(filepath1Yaml, filepath2Yaml);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_json.jsn"));
        assertThat(actual).isEqualTo(expected);
    }
}
