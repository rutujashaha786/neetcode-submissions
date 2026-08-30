class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        //itr- 1 : init with true
        for(int num : nums){
            map.put(num, true);
        }

        //itr - 2 : mark false if not start of sequence
        for(int num : nums){
            if(map.containsKey(num-1)){
                map.put(num, false);
            }
        }

        //cal longest length for entries with true
        int longest = 0;
        for(int num : map.keySet()){
            if(map.get(num)){
                int i = 0;
                while(map.containsKey(num + i)){
                    i++;
                }
                longest = Math.max(i, longest);
            }
        }

        return longest;

    }
}
