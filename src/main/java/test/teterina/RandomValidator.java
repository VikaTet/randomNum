package test.teterina;

public class RandomValidator {
    public static void validate(int[] randomNums, float[] probabilities){
        validateProbabilities(probabilities);
        validateNumberElements(randomNums, probabilities);

    }

    private static void validateProbabilities(float[] probabilities) {
        float sum = 0;
        for (float probability : probabilities) {
            sum += probability;
        }
        if (Math.abs(sum - 1.0f) > 0.000001f) {
            throw new IllegalArgumentException("Sum of probabilities must be equal to 1.");
        }
    }

    private static void validateNumberElements(int[] randomNums, float[] probabilities){
        if (randomNums.length<2 || probabilities.length<2){
            throw new IllegalStateException("The number of elements and probabilities must be more than 1");
        }
        if (randomNums.length!=probabilities.length){
            throw new IllegalStateException("The number of elements and probabilities must be the same");
        }

    }
}
