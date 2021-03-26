package at.nullpointer.brutechance;

import java.util.Arrays;
import java.util.stream.LongStream;

public class BruteChance {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long trys = 100000000;

        int[] chances = {100, 80, 5, 5, 5, 5, 5};
        int[] result = {0, 0, 0, 0, 0, 0, 0};

        LongStream.range(0, trys).parallel().forEach(i ->
                result[(int) calc(chances) - 1]++
        );

        long end = System.currentTimeMillis();

        Arrays.stream(result).forEach(r -> System.out.print(r + " Versuche, "));
        System.out.println();
        long einProzent = trys / 100;
        Arrays.stream(result).forEach(r -> System.out.print(Math.round(((double) r / einProzent) * 100) / 100 + "%;"));
        System.out.println();
        System.out.println("Processing Time: " + ((end - start) / 1000) + "Seconds");
    }

    private static long calc(int[] chances) {
        return Arrays.stream(chances)
                .filter(c -> c > 100 * Math.random()).count();
    }
}
