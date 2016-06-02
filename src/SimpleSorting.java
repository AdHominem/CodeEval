import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleSorting {

    public static void main(String[] args) throws IOException{
        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
            input.lines()
                    .map(line -> Arrays.asList(line.split(" ")).stream()
                                    .map(Double::valueOf)
                                    .sorted()
                                    .map(String::valueOf)
                                    .map(SimpleSorting::padWithZeroes)
                                    .collect(Collectors.joining(" ")))
                    .forEach(System.out::println);
        }
    }

    private static String padWithZeroes(String input) {
        String[] parts = input.split("\\.");
        StringBuilder front = new StringBuilder(parts[0]);
        StringBuilder decimalPart = new StringBuilder(parts[1]);

        while (decimalPart.length() < 3) {
            decimalPart.append("0");
        }
        return front + "." + decimalPart;
    }
}
