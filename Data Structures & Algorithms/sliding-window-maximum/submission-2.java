class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int i = 0; i < k; i++){
            pq.add(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];

        int j = 1;
        for(int i = k; i < n; i++){
            pq.add(new int[]{nums[i], i});

            //remove elements with stale index for current window
            while(pq.peek()[1] <= i - k){
                pq.remove();
            }

            res[j] = pq.peek()[0];
            j++; 
        }

        return res;
    }
}
