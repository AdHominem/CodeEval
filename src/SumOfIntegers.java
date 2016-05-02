import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class SumOfIntegers {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                                                    .map(SumOfIntegers::turnToIntegerList)
                                                    .map(SumOfIntegers::getAllContiguousSubarrays)
                                                    .forEach(System.out::println);
    }

    private static List<Integer> getAllContiguousSubarrays(List<Integer> integers) {
        return integers;
    }

    private static List<Integer> turnToIntegerList(String line) {
        List<String> lineAsList = Arrays.asList(line.split(","));
        return getAsIntegerList(lineAsList).stream()
                                           .collect(toList());
    }

    private static List<Integer> getAsIntegerList(List<String> stringList) {
        return stringList.stream()
                         .map(Integer::valueOf)
                         .collect(toList());
    }
}
