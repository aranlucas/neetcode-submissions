public class BehaviorTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        if (solution.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}) != 49) throw new AssertionError("Interior left wall");
        if (solution.maxArea(new int[] {1, 1}) != 1) throw new AssertionError("Two walls");
        if (solution.maxArea(new int[] {5, 1, 1, 5}) != 15) throw new AssertionError("Width matters");
        if (solution.maxArea(new int[] {0, 0}) != 0) throw new AssertionError("Zero height");
    }
}
