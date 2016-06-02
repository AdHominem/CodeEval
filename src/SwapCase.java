import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class SwapCase {

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
            input.lines()
                    .map(line -> Arrays.asList(line.split(" ")).stream()
                            .map(string -> swapCase(string))
                            .collect(joining(" ")))
                    .forEach(System.out::println);
        }
    }

    private static String swapCase(String line) {
        StringBuilder result = new StringBuilder(line.length());

        for (char letter : line.toCharArray()) {
            result.append(swapCase(letter));
        }

        return result.toString();
    }

    private static char swapCase(char letter) {
        if (letter == Character.toUpperCase(letter)) {
            return Character.toLowerCase(letter);
        } else {
            return Character.toUpperCase(letter);
        }
    }
}