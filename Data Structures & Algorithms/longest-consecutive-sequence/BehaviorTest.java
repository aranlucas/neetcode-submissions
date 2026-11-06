public class BehaviorTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        if (solution.longestConsecutive(new int[] {}) != 0) throw new AssertionError("Empty input");
        if (solution.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2, 2}) != 4) throw new AssertionError("Unordered run with duplicate");
        if (solution.longestConsecutive(new int[] {-2, -1, 0, 5}) != 3) throw new AssertionError("Run crossing zero");
        if (solution.longestConsecutive(new int[] {7, 7}) != 1) throw new AssertionError("One unique value");
    }
}
