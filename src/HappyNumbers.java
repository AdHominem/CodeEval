import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HappyNumbers {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                                                    .map(Integer::valueOf)
                                                    .map(HappyNumbers::determineIfHappy)
                                                    .forEach(System.out::println);

    }

    private static Integer determineIfHappy(Integer number) {
        return determineIfHappyRecursive(number, new ArrayList<>());
    }

    private static Integer determineIfHappyRecursive(Integer number, List<Integer> pastResults) {
        if (number == 1) {
            return 1;
        }

        final List<Integer> DIGITS = getDigitsOf(number);
        final Integer RESULT = squareAndSum(DIGITS);

        if (pastResults.contains(RESULT)) {
            return 0;
        }

        pastResults.add(RESULT);
        return determineIfHappyRecursive(RESULT, pastResults);
    }

    private static Integer squareAndSum(List<Integer> digits) {
        return digits.stream()
                .mapToInt(digit -> digit * digit)
                .sum();
    }

    private static List<Integer> getDigitsOf(Integer number) {
        final int DECIMAL_PLACES = number.toString().length();
        List<Integer> result = new ArrayList<>(DECIMAL_PLACES);

        for (int i = 0; i < DECIMAL_PLACES; i++) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }
}
