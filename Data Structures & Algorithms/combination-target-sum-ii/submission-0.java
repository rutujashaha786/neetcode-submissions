class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sharedSubsetList = new ArrayList<>();

        //IMP to handle duplicates with general subset solution
        Arrays.sort(candidates);

        combinationSum2Helper(candidates, target, 0, res, sharedSubsetList, 0);
        return res;
    }

    public void combinationSum2Helper(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> sharedSubsetList, int sum){
        if(sum == target){
            res.add(new ArrayList<>(sharedSubsetList));
            return;
        }

        if(index == candidates.length || sum > target){
            return;
        }

        sharedSubsetList.add(candidates[index]);
        combinationSum2Helper(candidates, target, index + 1 ,res, sharedSubsetList, sum + candidates[index]);

        sharedSubsetList.remove(sharedSubsetList.size() - 1);
        while(index +1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }

        combinationSum2Helper(candidates, target, index + 1 ,res, sharedSubsetList, sum);

    }
}
