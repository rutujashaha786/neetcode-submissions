class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi){

            //optimization if block
            if(nums[lo] <= nums[hi]){ //remaining search space is fully sorted 
                min = Math.min(min, nums[lo]);
                break; 
            }

            int mid = (lo + hi) / 2;

            if(nums[mid] < nums[hi]){ //right sorted, cant gaurantee Min not there, may have min
                min = Math.min(min, nums[mid]);  //sorted min easy to find out
                hi = mid - 1;
            }
            else{
                min = Math.min(nums[lo], min);
                lo = mid + 1;
            }
        }

        return min;
    }
}
