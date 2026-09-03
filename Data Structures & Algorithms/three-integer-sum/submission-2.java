class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){
            if(nums[i] > 0) break;

            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                if(left != i + 1 && nums[left] == nums[left - 1]){ //VIMP
                    left++;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);
                    left++;
                    right--;
                }
                else if(sum < 0){ //<target
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return triplets;

    }
}
