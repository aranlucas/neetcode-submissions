class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var sSorted = s.toCharArray();

        Arrays.sort(sSorted);

        var tSorted = t.toCharArray();
        
        Arrays.sort(tSorted);

        return Arrays.equals(sSorted, tSorted);
    }
}
