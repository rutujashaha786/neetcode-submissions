class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sharedSubSetList = new ArrayList<>();

        combinationSumHelper(nums, 0, 0, target, res, sharedSubSetList);

        return res;

    }

    public void combinationSumHelper(int[] nums, int index, int sum, int target, List<List<Integer>> res, List<Integer> sharedSubSetList){
        if(target == sum){
            res.add(new ArrayList<>(sharedSubSetList));
            return;
        }

        if(index == nums.length || sum > target){
            return;
        }

        sharedSubSetList.add(nums[index]);
        combinationSumHelper(nums, index, sum + nums[index], target, res, sharedSubSetList);

        sharedSubSetList.remove(sharedSubSetList.size() - 1);
        combinationSumHelper(nums, index + 1, sum, target, res, sharedSubSetList);


    }
}
