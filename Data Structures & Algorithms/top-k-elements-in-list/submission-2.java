class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqBucket = new List[nums.length + 1];
        for(int i = 0; i < freqBucket.length; i++){
            freqBucket[i] = new ArrayList<>();
        }

        for(int num : map.keySet()){
            int freq = map.get(num);

            freqBucket[freq].add(num);
        }

        int[] result = new int[k];
        int m = 0;

        for(int i = freqBucket.length - 1; i >= 0; i--){
            for(int num : freqBucket[i]){
                result[m] = num;
                m++;
                if(m == k){
                    return result;
                }
            }
        }

        return result;   

    }
}
