import java.util.Random;
import java.util.TreeMap;

public class Main {
    private final TreeMap<Integer, Integer> map;
    private final Random random = new Random(System.currentTimeMillis());
    private int sum = 0;

    public Main(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        return map.get(map.higherKey(random.nextInt(sum)));
    }


    public static void main(String[] args) {
        Main solution = new Main(new int[]{1});
        solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.

        solution = new Main(new int[]{1,3});
        solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
        solution.pickIndex(); // return 1
        solution.pickIndex(); // return 1
        solution.pickIndex(); // return 1
        solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
    }
}