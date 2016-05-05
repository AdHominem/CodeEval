import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lowercase {

    public static void main(String[] args) throws IOException {
        Files.newBufferedReader(Paths.get(args[0])).lines()
                                                    .map(String::toLowerCase)
                                                    .forEach(System.out::println);
    }
}
