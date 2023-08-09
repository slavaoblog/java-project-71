package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
//import java.util.Properties;

public class AppTest {

    @Test
    void testGetData() throws Exception {
        String filePath = "/home/smart/java-project-71/app/src/test/resources/file1.jsn";
        Path path = Paths.get(filePath);
        Map map = Differ.getData(path);

        assertThat(map.containsKey("follow"));
        assertThat(map.get("host").equals("hexlet.io"));
    }

    @Test
    void testGenerate() throws Exception {
        String filePath1 = "/home/smart/java-project-71/app/src/test/resources/file1.jsn";
        String filePath2 = "src/test/resources/file2.jsn";

        Path path1 = Paths.get(filePath1);
        Path path2 = Paths.get(filePath2);
        String str = Differ.generate(Differ.getData(path1), Differ.getData(path2));

        System.out.println(str);
        assertThat(str.contains("follow: false"));
    }
}
