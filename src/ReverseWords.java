import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                .filter(line -> line.length() > 0)
                .map(line -> line.split(" "))
                .map(ReverseWords::getAsListReversed)
                .map(wordList -> String.join(" ", wordList))
                .forEach(System.out::println);
    }

    private static List<String> getAsListReversed(String[] words) {
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        return wordList;
    }
}
