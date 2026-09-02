class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Binary search
        for(int i = 0; i < numbers.length - 1; i++){
            int compliment = target - numbers[i];
            int index = binarySearch(numbers, compliment, i + 1);
            if(index != -1){
                return new int[]{i + 1, index + 1};
            }
        }
        return new int[]{};

    }

    public int binarySearch(int[] numbers, int key, int strIndex){
        int i = strIndex;
        int j = numbers.length - 1;
        while(i <= j){
            int mid = (i + j) / 2;

            if(numbers[mid] == key){
                return mid;
            }
            else if(numbers[mid] < key){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        return -1;
    }
}
