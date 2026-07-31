class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int res = right;
        while (left <= right) {

            int mid = (left + right ) / 2;

            long totalTime = 0;

            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }
            if (totalTime <= h) {
                res = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
