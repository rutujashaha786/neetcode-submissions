class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums, 0);
    }

    public List<List<Integer>> permuteHelper(int[] nums, int index){
        if(index == nums.length){
            List<List<Integer>> bres = new ArrayList<>();
            bres.add(new ArrayList<>());
            return bres;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> sres = permuteHelper(nums, index + 1); 
        //[[2, 3], [3, 2]]
        int currentEle = nums[index];
        for(List<Integer> curr : sres){
            for(int i = 0; i <= curr.size(); i++){
                List<Integer> ncurr = new ArrayList<>(curr);
                ncurr.add(i, currentEle);
                res.add(ncurr);
            }
        }

        return res;

    }
}
