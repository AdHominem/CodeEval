import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;


/**
 *  A program to determine the largest sum of contiguous integers in a list.
 *  The first argument is a path to a filename containing a comma-separated list of integers, one per line.
 *  The largest sum is printed to stdout. In other words, of all the possible contiguous subarrays for a given array,
 *  the one with the largest sum is found and printed.
 */
public class SumOfIntegers {

    public static void main(String[] args) throws IOException {

        Files.newBufferedReader(Paths.get(args[0])).lines()
                                                    .map(SumOfIntegers::turnToIntegerList)
                                                    .map(SumOfIntegers::getAllContiguousSubarrays)
                                                    .map(SumOfIntegers::getSumsOfSubarrays)
                                                    .mapToInt(Collections::max)
                                                    .forEach(System.out::println);
    }

    private static List<Integer> turnToIntegerList(String line) {

        return asList(line.split(",")).stream()
                                      .map(Integer::valueOf)
                                      .collect(toList());
    }

    /**
     * Returns all possible contiguous subarrays for a given List. This method calls getEndTruncatedSubListsOf each
     * different frontTruncatedSubList, yielding all possible front and end truncated lists - which are all subarrays.
     * @param integerList A List containing Integer values.
     * @return A List of all subarrays as Lists.
     */
    private static List<List<Integer>> getAllContiguousSubarrays(List<Integer> integerList) {

        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> frontTruncatedSubList : getFrontTruncatedSubListsOf(integerList)) {
            result.addAll(getEndTruncatedSubListsOf(frontTruncatedSubList));
        }

        return result;
    }

    private static <T> List<List<T>> getFrontTruncatedSubListsOf(List<T> list) {
        return getSubListsOf(list, i -> list.subList(i, list.size()));
    }

    private static <T> List<List<T>> getEndTruncatedSubListsOf(List<T> list) {
        return getSubListsOf(list, i -> list.subList(0, list.size() - i));
    }

    private static <T> List<List<T>> getSubListsOf(List<T> list, IntFunction<List<T>> truncateFunction) {
        return IntStream.range(0, list.size())
                        .mapToObj(truncateFunction)
                        .collect(toList());
    }

    private static List<Integer> getSumsOfSubarrays(List<List<Integer>> subarrays) {
        return subarrays.stream()
                .map(subsubarray -> subsubarray.stream()
                                                .mapToInt(integer -> integer)
                                                .sum())
                .collect(toList());
    }



}
