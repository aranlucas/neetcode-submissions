class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            var exists = set.add(num);

            if (!exists) {
                return true;
            }
        }
        return false;
    }
}