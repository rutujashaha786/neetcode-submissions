class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sharedList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        permuteHelper(nums, visited, res, sharedList);
        return res;
    }

    //Backtracking with visited - shared list for perm and visited
    public void permuteHelper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> sharedList){
        if(sharedList.size() == nums.length){
            res.add(new ArrayList<>(sharedList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                sharedList.add(nums[i]);
                visited[i] = true;
                permuteHelper(nums, visited, res, sharedList);
                sharedList.remove(sharedList.size()-1);
                visited[i] = false;
            }  
        }

    }
}
