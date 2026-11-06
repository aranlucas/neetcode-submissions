public class BehaviorTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        if (!solution.hasDuplicate(new int[] {1, 2, 1})) throw new AssertionError("Separated duplicate");
        if (solution.hasDuplicate(new int[] {1, 2, 3})) throw new AssertionError("Distinct values");
        if (!solution.hasDuplicate(new int[] {0, -1, -1})) throw new AssertionError("Negative duplicate");
    }
}
