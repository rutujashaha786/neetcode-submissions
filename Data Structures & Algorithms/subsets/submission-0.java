class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sharedListSubset = new ArrayList<>();

        subsetsHelper(nums, 0, res, sharedListSubset);

        return res;

    }

    public void subsetsHelper(int[] nums, int index, List<List<Integer>> res, List<Integer> sharedListSubset){
        if(index == nums.length){
            res.add(new ArrayList<>(sharedListSubset));
            return;
        }

        sharedListSubset.add(nums[index]);
        subsetsHelper(nums, index + 1, res, sharedListSubset);

        sharedListSubset.remove(sharedListSubset.size()-1);
        subsetsHelper(nums, index + 1, res, sharedListSubset);

    }
}
