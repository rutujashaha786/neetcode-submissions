class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(nums, 0);
    }

    public List<List<Integer>> subsetsHelper(int[] nums, int index){
        if(index == nums.length){
            List<List<Integer>> bres = new ArrayList<>();
            bres.add(new ArrayList<>());
            return bres;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> childResList = subsetsHelper(nums, index+1);

        for(List<Integer> childRes : childResList){
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[index]);
            subList.addAll(childRes);
            res.add(subList);
        }

        res.addAll(childResList);
        return res;
    }
}
