class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        for(char ch : s.toCharArray()){
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);

            if(!smap.containsKey(ch)){
                return false;
            }

            smap.put(ch, smap.get(ch) - 1);
            if(smap.get(ch) == 0){
                smap.remove(ch);
            }
        }

        return smap.size() == 0;

    }
}
