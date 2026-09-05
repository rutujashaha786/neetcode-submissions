class Solution {
    public int trap(int[] height) {
        //Math.min(MaxHeightOnLeft, maxHeightOnRight) - height[i]

        int sum = 0;
        int n = height.length;

        //precompute MaxHeightOnLeft for each index - max till this index
        int[] maxSoFarLeft = new int[n];
        maxSoFarLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxSoFarLeft[i] = Math.max(maxSoFarLeft[i-1], height[i]);
        }

        int[] maxSoFarRight = new int[n];
        maxSoFarRight[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--){
            maxSoFarRight[i] = Math.max(maxSoFarRight[i+1], height[i]);
        }

        for(int i = 0; i < n; i++){
            sum = sum + Math.min(maxSoFarLeft[i], maxSoFarRight[i]) - height[i];
        }
        return sum;
    }
}
