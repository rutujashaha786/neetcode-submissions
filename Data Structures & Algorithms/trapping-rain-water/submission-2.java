class Solution {
    public int trap(int[] height) {
        //Math.min(MaxHeightOnLeft, maxHeightOnRight) - height[i]

        int sum = 0;
        int n = height.length;

        int lmax = height[0];
        int rmax = height[n-1];

        int i = 0;
        int j = n - 1;

        int res = 0;
        while(i < j){
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);

            if(lmax < rmax){
                res = res + lmax - height[i];
                i++;
            }
            else{
                res = res + rmax - height[j];
                j--;
            }
        }

        return res;
    }
}
