import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                                                   .map(FizzBuzz::getArgumentsFrom)
                                                   .map(FizzBuzz::fizzbuzz)
                                                   .forEach(System.out::println);
    }

    private static String fizzbuzz(List<Integer> arguments) {
        final int divisorOne = arguments.get(0);
        final int divisorTwo = arguments.get(1);

        return IntStream.rangeClosed(1,arguments.get(2))
                        .mapToObj(number -> (number % lcm(divisorOne, divisorTwo) == 0) ? "FB" : (number % divisorOne ==
                                0) ? "F" : (number % divisorTwo == 0) ? "B" : number)
                        .map(Object::toString)
                        .collect(joining(" "));
    }

    private static int lcm(int numberOne, int numberTwo) {
        final int bigger = Math.max(numberOne, numberTwo);
        final int smaller = Math.min(numberOne, numberTwo);

        return IntStream.rangeClosed(1,smaller)
                        .filter(factor -> (factor * bigger) % smaller == 0)
                        .map(factor -> Math.abs(factor * bigger))
                        .findFirst()
                        .getAsInt();
    }

    private static List<Integer> getArgumentsFrom(String input) {
        return Arrays.asList(input.split(" ")).stream()
                                              .map(Integer::valueOf)
                                              .collect(toList());
    }
}
