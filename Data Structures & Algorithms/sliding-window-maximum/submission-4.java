class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < k; i++){
            //if smaller elemts in dq than current, remove those then add current
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        int j = 0;
        for(int i = k; i < n; i++){
            res[j] = nums[dq.getFirst()];
            j++;

            if(dq.getFirst() <= i - k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.removeLast();
            }

             dq.addLast(i);
        }

        //as we calc res on next window start, for last window
        res[j] = nums[dq.getFirst()];

        return res;
       
    }
}
