import java.util.*;

public class BehaviorTest {
    public static void main(String[] args) {
        int[] actual = new Solution().topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        Arrays.sort(actual);
        if (!Arrays.equals(actual, new int[] {1, 2})) throw new AssertionError("Most frequent membership");
        actual = new Solution().topKFrequent(new int[] {-1, -1, 2, 3, 3, 3}, 1);
        if (!Arrays.equals(actual, new int[] {3})) throw new AssertionError("Single most frequent");
        actual = new Solution().topKFrequent(new int[] {-1, 2}, 2);
        Arrays.sort(actual);
        if (!Arrays.equals(actual, new int[] {-1, 2})) throw new AssertionError("All unique values requested");
    }
}
