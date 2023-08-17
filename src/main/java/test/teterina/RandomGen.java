package test.teterina;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class RandomGen {
    private final int[] randomNums;
    private final float[] cumulativeProbabilities;
    private final Random rand = new Random();

    public float[] getCumulativeProbabilities() {
        return cumulativeProbabilities;
    }

    public RandomGen(int[] randomNums, float[] probabilities) {
        RandomValidator.validate(randomNums, probabilities);
        this.randomNums = randomNums;
        this.cumulativeProbabilities = calculateCumulativeProbabilities(probabilities);
    }

    private float[] calculateCumulativeProbabilities(float[] probabilities) {
        float[] cumulativeProbabilities = new float[probabilities.length];
        float sum = 0;
        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
            cumulativeProbabilities[i] = sum;
        }
        return cumulativeProbabilities;
    }

    public int nextNum() {
        float randVal = rand.nextFloat();
        for (int i = 0; i < cumulativeProbabilities.length; i++) {
            if (randVal < cumulativeProbabilities[i]) {
                return randomNums[i];
            }
        }
        // Shouldn't reach here if probabilities sum up to 1
        throw new IllegalStateException("Probabilities do not sum up to 1");
    }
}
