package hexlet.code;

//import org.codehaus.jackson.map.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.*;
import java.util.Map;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        Path absolutePath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        if (!Files.exists(absolutePath1)) {
            throw new Exception("File '" + absolutePath1 + "' does not exist");
        }
        Path absolutePath2 = Paths.get(filepath2).toAbsolutePath().normalize();
        if (!Files.exists(absolutePath2)) {
            throw new Exception("File '" + absolutePath2 + "' does not exist");
        }
        Map<String, String> file1 = Differ.getData(absolutePath1);
        Map<String, String> file2 = Differ.getData(absolutePath2);

        System.out.println(Differ.generate(file1, file2));
        return 0;
    }

    public static void main(String... args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
