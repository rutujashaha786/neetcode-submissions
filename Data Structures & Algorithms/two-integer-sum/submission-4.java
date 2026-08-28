class Solution {
    public int[] twoSum(int[] nums, int target) {
        //As want to return original index, and sorting changes positions, so preserve INDEX
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = n - 1;
        while(i < j){
            int sum = arr[i][0] + arr[j][0];

            if(sum == target){
                int index1 = arr[i][1];
                int index2 = arr[j][1];

                return index1 < index2 ? new int[]{index1, index2} : new int[]{index2, index1};
            }
            else if(sum > target){
                j--;
            }
            else{
                i++;
            }

        }
        return new int[0];
        
    }
}
