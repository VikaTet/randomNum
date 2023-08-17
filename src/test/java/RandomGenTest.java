import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.teterina.RandomGen;

import static org.junit.jupiter.api.Assertions.*;

class RandomGenTest {

    private RandomGen randomGen;

    @BeforeEach
    void setUp() {
        randomGen = new RandomGen(new int[]{-1, 0, 1, 2, 3}, new float[]{0.01f, 0.3f, 0.58f, 0.1f, 0.01f});
    }

    @Test
    void testNextNumValidity() {
        for (int i = 0; i < 1000; i++) {
            int num = randomGen.nextNum();
            assertTrue(num >= -1 && num <= 3);
        }
    }

    @Test
    void testProbabilityDistribution() {
        int[] results = new int[5];
        for (int i = 0; i < 100000; i++) {
            int num = randomGen.nextNum();
            results[num + 1]++;
        }

        // Roughly check if the distribution is as expected
        assertTrue(results[0] > 500 && results[0] < 1500);   // -1 with 0.01 probability
        assertTrue(results[1] > 28000 && results[1] < 32000); // 0 with 0.3 probability
        assertTrue(results[2] > 57000 && results[2] < 59000); // 1 with 0.58 probability
        assertTrue(results[3] > 8000 && results[3] < 12000);  // 2 with 0.1 probability
        assertTrue(results[4] > 500 && results[4] < 1500);   // 3 with 0.01 probability
    }

    @Test
    void testCumulativeProbabilities() {
        float[] cumulative = randomGen.getCumulativeProbabilities();  // Assuming you add a getter for this in RandomGen
        assertArrayEquals(new float[]{0.01f, 0.31f, 0.89f, 0.99f, 1.0f}, cumulative, 0.01f);
    }
}