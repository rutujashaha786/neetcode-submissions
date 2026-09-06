class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch) + 1);
            }

            map.put(ch, end);
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
