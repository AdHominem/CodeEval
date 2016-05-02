import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FibonacciSeries {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                .mapToInt(Integer::valueOf)
                .map(FibonacciSeries::fibonacci)
                .forEach(System.out::println);
    }

    private static int fibonacci(int number) {
        return number > 1 ? fibonacci(number - 2) + fibonacci(number - 1) : number;
    }
}
