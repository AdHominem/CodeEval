import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class CapitalizeWords {

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
            input.lines()
                 .map(line -> Arrays.asList(line.split(" ")).stream()
                                                            .map(string -> capitalize(string))
                                                            .collect(joining(" ")))
                 .forEach(System.out::println);
        }
    }

    private static String capitalize(String line) {
        StringBuilder result = new StringBuilder(line);
        result.setCharAt(0,Character.toUpperCase(result.charAt(0)));
        return result.toString();
    }
}