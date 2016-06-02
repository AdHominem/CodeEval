import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MersennePrime {

    public static void main(String[] args) throws IOException {

        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
            input.lines()
                    .map(Integer::valueOf)
                    .map(number -> IntStream.iterate(2, i -> i*2 - 1)
                                            .limit(number)
                                            .filter(MersennePrime::isPrime)
                                            .mapToObj(e -> e)
                                            .collect(toList()))
                    .forEach(MersennePrime::printList);
        }
    }

    private static void printList(List<Integer> list) {
        System.out.println(list.stream()
                                .map(String::valueOf)
                                .collect(joining(", ")));
    }

    private static boolean isMersenne(int number) {
        return Integer.toBinaryString(number + 1).chars()
                .filter(character -> character == '1')
                .count() == 1;
    }

    private static boolean isPrime(int potentialPrime) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(potentialPrime))
                .noneMatch(e -> potentialPrime % e == 0);
    }
}