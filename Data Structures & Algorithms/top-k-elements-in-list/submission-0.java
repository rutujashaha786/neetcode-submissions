class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> pairsList = new ArrayList<>();

        for(int num : map.keySet()){
            pairsList.add(new int[]{map.get(num), num});
        }

        //Sort the list of arrays based on frequency in descending order
        Collections.sort(pairsList, (a, b) -> Integer.compare(b[0], a[0]));

        //Traverse list
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            int[] pair = pairsList.get(i);
            result[i] = pair[1];
        }

        return result;
    }
}
