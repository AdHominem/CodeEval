import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RollerCoaster {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                .map(String::toLowerCase)
                .map(RollerCoaster::mixedCase)
                .forEach(System.out::println);
    }

    public static String mixedCase(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(i -> i % 2 == 0 ? Character.toUpperCase(str.charAt(i)) : str.charAt(i))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String rollerCoasterCase(String line) {

        StringBuilder result = new StringBuilder();
        int index = 0;

        for (char character : line.toCharArray()) {
            if (Character.isLetter(character)) {
                if (index % 2 == 0) {
                    result.append(Character.toUpperCase(character));
                } else {
                    result.append(character);
                }
                index++;
            } else {
                result.append(character);
            }
        }

//        for (char character : line.toCharArray()) {
//
//        }

        return result.toString();
    }

    private static List<Character> getAsCharacterList(String string) {
        return string.chars()
                .mapToObj(integerCharacter -> (char) integerCharacter)
                .collect(toList());
    }
}
