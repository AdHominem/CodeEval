import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MersennePrime {

    public static void main(String[] args) throws IOException {

        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
            List<Integer> numbers = input.lines()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            for (final int limit : numbers) {
                List<Integer> result = new ArrayList<>();

                for (int mersenne = 1; mersenne <= limit; mersenne <<= 1) {
                    if (isPrime(mersenne - 1)) {
                        result.add(mersenne - 1);
                    }
                }

                System.out.println(result.stream()
                                            .map(String::valueOf)
                                            .collect(Collectors.joining(", ")));
            }
        }
    }

    private static boolean isPrime(int potentialPrime) {
        return potentialPrime >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(potentialPrime))
                                            .noneMatch(e -> potentialPrime % e == 0);
    }
}