class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int best = 1;
        for (int num: set) {

            boolean exists = set.contains(num -1);
            if (exists) {
                continue;
            }

            int current = 1;

            int sequence = num + 1;

            while (set.contains(sequence)) {
                sequence++;
                current++;
            }

            best = Math.max(best, current);
        }

        return best;
    }
}
