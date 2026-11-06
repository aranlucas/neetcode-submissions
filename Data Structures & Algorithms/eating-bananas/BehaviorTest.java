public class BehaviorTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        if (solution.minEatingSpeed(new int[] {3, 6, 7, 11}, 8) != 4) throw new AssertionError("Round each pile up");
        if (solution.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5) != 30) throw new AssertionError("One hour per pile");
        if (solution.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6) != 23) throw new AssertionError("Minimum feasible rate");
        if (solution.minEatingSpeed(new int[] {1, 1}, 3) != 1) throw new AssertionError("Rate lower bound");
        if (solution.minEatingSpeed(new int[] {1000000000, 1000000000, 1000000000}, 1000000000) != 4) throw new AssertionError("Total hours exceed int range");
    }
}
