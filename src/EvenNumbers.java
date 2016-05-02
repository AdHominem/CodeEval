import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EvenNumbers {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                .map(Integer::valueOf)
                .map(number -> (number % 2 == 0) ? 1 : 0)
                .forEach(System.out::println);
    }
}
