import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumOfDigits {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                                                   .map(line -> line.chars()
                                                                    .map(Character::getNumericValue)
                                                                    .sum())
                                                   .forEach(System.out::println);
    }
}
