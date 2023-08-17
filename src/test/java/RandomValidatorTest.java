import org.junit.jupiter.api.Test;
import test.teterina.RandomValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomValidatorTest {

    @Test
    public void testValidProbabilities() {
        int[] nums = {3, 6, 5, 8, 17};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};

        assertDoesNotThrow(() -> RandomValidator.validate(nums, probabilities));
    }

    @Test
    public void testInvalidProbabilitiesSum() {
        int[] nums = {3, 6, 5, 8, 17};
        float[] probabilities = {0.01f, 0.3f, 0.59f, 0.1f, 0.01f};

        assertThrows(IllegalArgumentException.class, () -> RandomValidator.validate(nums, probabilities));
    }

    @Test
    public void testMismatchedArrayLengths() {
        int[] nums = {3, 6, 5, 8};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};

        assertThrows(IllegalStateException.class, () -> RandomValidator.validate(nums, probabilities));
    }

    @Test
    public void testEmptyArrays() {
        int[] nums = {};
        float[] probabilities = {};

        assertThrows(IllegalArgumentException.class, () -> RandomValidator.validate(nums, probabilities));
    }
}