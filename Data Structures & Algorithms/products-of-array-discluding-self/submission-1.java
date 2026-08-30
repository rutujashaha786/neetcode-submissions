class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int zeroCount = 0;
        int singleZeroIndex = -1;
        int totalNonZeroProduct = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                singleZeroIndex = i;
            }
            else{
                totalNonZeroProduct *= nums[i];
            }
        }

        if(zeroCount == 1){
            res[singleZeroIndex] = totalNonZeroProduct;
            return res;
        }

        if(zeroCount > 1){
            return res;
        }

        for(int i = 0; i < n; i++){
            res[i] = totalNonZeroProduct / nums[i];
        }
        return res;
    }
}  
