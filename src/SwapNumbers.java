import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SwapNumbers {

    public static void main(String[] args) throws IOException {


        String token = "dfgd[1:6]";
        System.out.println(token.matches("(.*)\\[\\d\\:\\d\\](.*)"));

        String token2 = "import java.util.stream.*;";
        System.out.println(token2.contains("java"));
//        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]))) {
//            input.lines()
//                 .map(line -> Arrays.asList(line.split(" ")).stream()
//                                                .map(word -> word.charAt(word.length()-1)
//                                                        + word.substring(1,word.length()-1)
//                                                        + word.charAt(0))
//                                                .collect(Collectors.joining(" ")))
//                 .forEach(System.out::println);
//        }
    }
}
