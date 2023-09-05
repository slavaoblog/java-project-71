package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {
    private final String filepath1Json = ("src/test/resources/file1.jsn");
    private final String filepath2Json = ("src/test/resources/file2.jsn");
    private final String filepath3Json = ("src/test/resources/file3.jsn");
    private final String filepath4Json = ("src/test/resources/file4.jsn");
    private final String filepath1Yaml = ("src/test/resources/file1.yml");
    private final String filepath2Yaml = ("src/test/resources/file2.yml");
    private final String filepath3Yaml = ("src/test/resources/file3.yml");
    private final String filepath4Yaml = ("src/test/resources/file4.yml");

//    @Test
//    void testStylishJson() throws Exception {
//        String actual = Differ.generate(filepath1Json, filepath2Json);
//        String expected = Files.readString(Paths.get("src/test/resources/output_plain"));
//        assertThat(actual).isEqualTo(expected);
//    }
//    @Test
//    void testPlainYaml() throws Exception {
//        String actual = Differ.generate(filepath1Yaml, filepath2Yaml);
//        String expected = Files.readString(Paths.get("src/test/resources/output_plain"));
//        assertThat(actual).isEqualTo(expected);
//    }

    @Test
    void testNestedJson() throws Exception {
        String actual = Differ.generate(filepath3Json, filepath4Json);
        String expected = Files.readString(Paths.get("src/test/resources/output_nested"));
        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}
