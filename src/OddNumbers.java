import java.util.stream.IntStream;

public class OddNumbers {

    public static void main (String[] args) {
        IntStream.rangeClosed(1,99)
                .filter(number -> number % 2 == 1)
                .forEach(System.out::println);
    }
}
