class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sharedList = new ArrayList<>();

        subsetsWithDupHelper(nums, 0, sharedList, res);

        return res;
    }

    public void subsetsWithDupHelper(int[] nums, int i, List<Integer> sharedList, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(sharedList));
            return;
        }

        sharedList.add(nums[i]);
        subsetsWithDupHelper(nums, i+1, sharedList, res);

        sharedList.remove(sharedList.size() - 1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        subsetsWithDupHelper(nums, i+1, sharedList, res);

    }
}
