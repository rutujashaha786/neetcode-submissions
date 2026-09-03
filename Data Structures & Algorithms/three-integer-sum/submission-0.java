class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
         List<List<Integer>> triplets = new ArrayList<>();
        //sort array
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int smallTarget = - nums[i];

            List<List<Integer>> pairs = twoSum(nums, i + 1, n - 1, smallTarget);
            for(List<Integer> pair : pairs){
                pair.add(nums[i]);
                triplets.add(pair);
            }
             
        }
        return triplets;
    }

    public List<List<Integer>> twoSum(int[] nums, int str, int end, int target){
        int i = str;
        int j = end;

        List<List<Integer>> pairs = new ArrayList<>();

        while(i < j){
            if(i != str && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            int sum = nums[i] + nums[j];
            if(sum < target){
                i++;
            }
            else if(sum > target){
                j--;
            }
            else{
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(nums[j]);
                pairs.add(pair);
                i++;
                j--;
            }
        }
        return pairs;
    }
}
