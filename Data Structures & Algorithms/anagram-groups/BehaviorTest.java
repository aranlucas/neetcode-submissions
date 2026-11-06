import java.util.*;

public class BehaviorTest {
    public static void main(String[] args) {
        List<List<String>> actual = new Solution().groupAnagrams(
            new String[] {"eat", "tea", "tan", "ate", "nat", "bat", "eat"});
        List<List<String>> expected = List.of(
            List.of("ate", "eat", "eat", "tea"), List.of("nat", "tan"), List.of("bat"));
        // The judge permits any group/member order; duplicates still count.
        List<List<String>> normalized = new ArrayList<>();
        for (List<String> group : actual) {
            List<String> sorted = new ArrayList<>(group);
            Collections.sort(sorted);
            normalized.add(sorted);
        }
        if (normalized.size() != expected.size()
                || !new HashSet<>(normalized).equals(new HashSet<>(expected))) {
            throw new AssertionError("Anagram groups and multiplicities: " + actual);
        }
        if (!new Solution().groupAnagrams(new String[] {""}).equals(List.of(List.of("")))) {
            throw new AssertionError("Empty string is a group member");
        }
    }
}
