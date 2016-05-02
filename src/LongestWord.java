import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class LongestWord {

    public static void main(String[] args) throws IOException, NoSuchElementException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                .map(line -> Arrays.asList(line.split(" ")).stream()
                                                           .max(Comparator.comparing(String::length))
                                                           .get())
                .forEach(System.out::println);
    }
}