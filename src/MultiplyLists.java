import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MultiplyLists {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                .map(line -> Arrays.asList(line.split(" \\| ")))
                .map(MultiplyLists::multiplyCorresponding)
                .forEach(System.out::println);

    }

    private static String multiplyCorresponding(List<String> lists) {
        List<Integer> firstList = getAsIntegerList(Arrays.asList(lists.get(0).split(" ")));
        List<Integer> secondList = getAsIntegerList(Arrays.asList(lists.get(1).split(" ")));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < firstList.size(); i++) {
            result.append(firstList.get(i) * secondList.get(i));
        }

        return result.toString();
    }

    private static List<Integer> getAsIntegerList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::valueOf)
                .collect(toList());
    }
}
