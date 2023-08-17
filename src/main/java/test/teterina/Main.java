package test.teterina;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] testRandomNums = {-1, 0, 1, 2, 3};
        float[] testProbabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        RandomGen randomGen = new RandomGen(testRandomNums, testProbabilities);
        IntSupplier randomGenSupplier = randomGen::nextNum;
        Map<Integer, Integer> resultMap = new HashMap<>();

        IntStream.generate(randomGenSupplier)
                .limit(1000)
                .forEach(num -> resultMap.put(num, resultMap.getOrDefault(num, 0) + 1));

        resultMap.forEach((key, value) -> System.out.println(key + ": " + value + " times"));
    }
}
