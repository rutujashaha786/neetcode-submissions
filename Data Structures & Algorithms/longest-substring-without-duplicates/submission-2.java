class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) == 2){
                char ch1 = s.charAt(start);
                map.put(ch1, map.get(ch1) - 1);
                if(map.get(ch1) == 0){
                    map.remove(ch1);
                }
                start++;
            }

            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
