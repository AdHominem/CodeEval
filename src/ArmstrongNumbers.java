import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumbers {
    public static void main (String[] args) throws IOException {

        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
            input.lines()
                    .mapToInt(Integer::valueOf)
                    .mapToObj(ArmstrongNumbers::isArmstrong)
                    .map(ArmstrongNumbers::capitalize)
                    .forEach(System.out::println);
        }
    }

    private static boolean isArmstrong(Integer number) {
        final int digitsNumber = number.toString().length();

        final Double sumOfDigits = getDigitsOf(number).stream()
                                                      .mapToDouble(digit -> Math.pow(digit, digitsNumber))
                                                      .sum();

        return sumOfDigits.intValue() == number;
    }

    private static List<Integer> getDigitsOf(Integer number) {
        List<Integer> result = new ArrayList<>();

        while (number > 0) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }

    private static String capitalize(Boolean bool) {
        String result = bool.toString();
        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }


}

