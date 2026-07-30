class Solution {
    public boolean isAnagram(String s, String t) {
        var sSorted = s.toCharArray();

        Arrays.sort(sSorted);

        var tSorted = t.toCharArray();
        
        Arrays.sort(tSorted);

        return Arrays.equals(sSorted, tSorted);
    }
}
