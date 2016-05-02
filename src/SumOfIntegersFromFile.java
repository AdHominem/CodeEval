import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumOfIntegersFromFile {

    public static void main(String[] args) throws IOException {

        System.out.println(Files.newBufferedReader(Paths.get(args[0])).lines()
                        .mapToInt(Integer::parseInt)
                        .sum());
    }
}
