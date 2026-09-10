class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        //s1 hasmap
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //s2 initial fixed size hashmap - 1
        HashMap<Character, Integer> s2map = new HashMap<>();
        for(int i = 0; i < s1.length() - 1; i++){
            char ch = s2.charAt(i);
            s2map.put(ch, s2map.getOrDefault(ch, 0) + 1);
        }

        //acquire/release
        for(int i = s1.length() - 1; i < s2.length(); i++){
            //acquire
            char ch = s2.charAt(i);
            s2map.put(ch, s2map.getOrDefault(ch, 0) + 1);

            //calculate res of fixed window
            if(map.equals(s2map)){
                return true;
            }

            //releas
            int left = i - s1.length() + 1;
            char leftChar = s2.charAt(left);
            s2map.put(leftChar, s2map.get(leftChar) - 1);

            if(s2map.get(leftChar) == 0){
                s2map.remove(leftChar);
            }

        }

        return false;

    }
}
