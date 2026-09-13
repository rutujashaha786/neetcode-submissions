class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        HashMap<Character, Integer> tmap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        int need = tmap.size(); //----to detect valid window

        int minLength = Integer.MAX_VALUE;
        String res = "";
        int startIndex = -1; //needed, bcz substring in while loop, TLE as new string creation for long string inputs

        HashMap<Character, Integer> smap = new HashMap<>();
        int start = 0;

        int count = 0;
        for(int end = 0; end < s.length(); end++){
            //acquire
            char ch = s.charAt(end);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if(tmap.containsKey(ch) && smap.get(ch).equals(tmap.get(ch))){
                count++;
            }

            //release { res update + release}
            while(count == need){
                if(end - start + 1 < minLength){
                    minLength = end - start + 1;
                    startIndex = start;
                }

                char ch1 = s.charAt(start);
                smap.put(ch1, smap.get(ch1) - 1);
                if(smap.get(ch1) == 0){
                    smap.remove(ch1);
                }

                if(tmap.containsKey(ch1) && smap.getOrDefault(ch1, 0) < tmap.get(ch1)){
                    count--;
                }
                start++;
            }

        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);

        
    }
}
