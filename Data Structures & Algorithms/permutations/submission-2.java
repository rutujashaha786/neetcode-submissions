class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sharedList = new ArrayList<>();

        permute(nums, 0, sharedList, res);

        return res;

    }

    public void permute(int[] nums, int idx, List<Integer> sharedList, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(sharedList));
            return;
        }

        for(int i = idx; i < nums.length; i++){   
            swap(nums, idx, i);
            sharedList.add(nums[idx]);
            permute(nums, idx+1, sharedList, res);
            swap(nums, idx, i);
            sharedList.remove(sharedList.size()-1);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
