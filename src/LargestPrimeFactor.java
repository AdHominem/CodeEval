import java.util.Scanner;
import java.util.stream.LongStream;

public class LargestPrimeFactor {

    public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                LongStream.range(0, scanner.nextLong())
                        .map(element -> scanner.nextLong())
                        .map(number -> getLargestPrimeFactorOf(number))
                        .forEach(System.out::println);
            }
    }


    private static long getLargestPrimeFactorOf(long number) {

        while (number % 2 == 0) {
            number /= 2;
        }
        if (number == 1) return 2;

        long divisor = 3;
        while (divisor <= Math.ceil(Math.sqrt(number))) {
            if (number % divisor == 0) {
                number /= divisor;
            } else {
                divisor += 2;
            }
        }

        return (number > 2) ? number : divisor;
    }
}
