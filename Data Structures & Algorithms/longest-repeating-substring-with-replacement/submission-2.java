class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxf = 0;

        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxf = Math.max(maxf, map.get(ch));

            while(end - start + 1 - maxf > k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                maxf = Collections.max(map.values()); //maxf update 
                
                if(map.get(s.charAt(start)) == 0){
                    map.remove(s.charAt(start));
                }
                start++;
            }

            longest = Math.max(longest, end - start + 1);
        }

        return longest;
      
    }
}
