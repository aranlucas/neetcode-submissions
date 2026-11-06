public class BehaviorTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        if (!solution.isAnagram("anagram", "nagaram")) throw new AssertionError("Reordered letters");
        if (solution.isAnagram("aab", "abb")) throw new AssertionError("Letter multiplicity");
        if (solution.isAnagram("ab", "a")) throw new AssertionError("Unequal lengths");
    }
}
