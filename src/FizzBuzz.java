import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        Files.newBufferedReader(Paths.get(args[0])).lines()
             .map(FizzBuzz::process)
             .forEach(System.out::println);
    }

    private static String process(String input) {
        return fizzbuzz(getArgumentsFrom(input));
    }

    private static String fizzbuzz(List<Integer> arguments) {
        final int divisorOne = arguments.get(0);
        final int divisorTwo = arguments.get(1);

        return IntStream.rangeClosed(1,arguments.get(2))
                        .mapToObj(e -> (e % (divisorOne * divisorTwo) == 0) ? "FB" : (e % divisorOne == 0) ? "F" :
                                (e % divisorTwo == 0) ? "B" : e)
                        .map(Object::toString)
                        .collect(joining(" "));
    }

    private static List<Integer> getArgumentsFrom(String input) {
        List<Integer> result = new ArrayList<>();
        for (String argument : input.split(" ")) {
            result.add(Integer.valueOf(argument));
        }
        return result;
    }
}
