class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();

        for (int num: nums) {
            count.put(num, count.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (var entry : count.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }

        return result;
    }
}
