import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testSingleElement() {
        Main solution = new Main(new int[]{1});
        assertEquals(0, solution.pickIndex(), "The only option should be 0");
    }

    @Test
    public void testMultipleElements() {
        int[] weights = {1, 3};
        Main solution = new Main(weights);

        // Since this is probabilistic, we need to run it multiple times to check the distribution
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int pickedIndex = solution.pickIndex();
            countMap.put(pickedIndex, countMap.getOrDefault(pickedIndex, 0) + 1);
        }

        // The expected ratio should be approximately 1:3 for indices 0 and 1 respectively
        double ratio = (double) countMap.get(0) / countMap.get(1);
        double expectedRatio = 1.0 / 3.0;

        assertTrue(Math.abs(ratio - expectedRatio) < 0.1, "The ratio should be approximately 1:3");
    }

    @Test
    public void testLargeWeights() {
        int[] weights = {1, 99};
        Main solution = new Main(weights);

        // Since this is probabilistic, we need to run it multiple times to check the distribution
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int pickedIndex = solution.pickIndex();
            countMap.put(pickedIndex, countMap.getOrDefault(pickedIndex, 0) + 1);
        }

        // The expected ratio should be approximately 1:99 for indices 0 and 1 respectively
        double ratio = (double) countMap.get(0) / countMap.get(1);
        double expectedRatio = 1.0 / 99.0;

        assertTrue(Math.abs(ratio - expectedRatio) < 0.05, "The ratio should be approximately 1:99");
    }
}