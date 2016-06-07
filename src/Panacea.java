import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Panacea {

    public static void main(String[] args) throws IOException {

        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {

            input.lines()
                    .map(line -> turnToTuple(line))
                    .forEach(tuple -> System.out.println(tuple.toString()));

        }
    }

    private static Tuple<String> turnToTuple(String line) {
        String[] parts = line.split("\\|");
        return new Tuple<String>(parts[0], parts[1]);
    }
}

class Tuple <T> {

    private T left;
    private T right;

    Tuple(T left, T right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left + " " + right;
    }
}