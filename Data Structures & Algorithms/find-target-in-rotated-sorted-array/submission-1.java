class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int minIndex = findMinIndex(nums);

        if(target == nums[minIndex]){
            return minIndex;
        }

        if(target > nums[minIndex] && target <= nums[n - 1]){
            return binarySearch(nums, minIndex + 1, n - 1, target);
        }

        return binarySearch(nums, 0, minIndex - 1, target);

    }

    public int binarySearch(int[] nums, int lo, int hi, int target){
        int i = lo;
        int j = hi;

        while(i <= j){
            int mid = (i+j)/2;

            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }
        return -1;
    }

    public int findMinIndex(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi){

            //optimization if block
            if(nums[lo] <= nums[hi]){ //remaining search space is fully sorted 
                // min = Math.min(min, nums[lo]);
                if(nums[lo] < min){
                    min = nums[lo];
                    minIndex = lo;
                }
                break; 
            }

            int mid = (lo + hi) / 2;

            if(nums[mid] < nums[hi]){ //right sorted, cant gaurantee Min not there, may have min
                // min = Math.min(min, nums[mid]);  //sorted min easy to find out

                if(nums[mid] < min){
                    min = nums[mid];
                    minIndex = mid;
                }
                hi = mid - 1;
            }
            else{
                // min = Math.min(nums[lo], min);

                 if(nums[lo] < min){
                    min = nums[lo];
                    minIndex = lo;
                }
                lo = mid + 1;
            }
        }

        return minIndex;
    }
}
