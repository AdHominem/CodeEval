import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SumOfPrimes {

    public static void main(String[] args) {

        System.out.println(getFirstThousandPrimes().stream()
                                                   .mapToInt(e -> e)
                                                   .sum()
        );
    }

    private static List<Integer> getFirstThousandPrimes() {
        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int number = 2; count < 1000; number++) {
            if (isPrime(number)) {
                result.add(number);
                count++;
            }
        }

        return result;
    }

    private static boolean isPrime(int potentialPrime) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(potentialPrime))
                        .noneMatch(e -> potentialPrime % e == 0);
    }
}
