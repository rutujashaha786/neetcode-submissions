class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Sort s1
        char[] s1arr = s1.toCharArray();
        Arrays.sort(s1arr);
        String s1sort = String.valueOf(s1arr);

        for(int i = 0; i <= s2.length() - s1.length(); i++){
            String substr = s2.substring(i, i + s1.length());

            char[] s2subarr = substr.toCharArray();
            Arrays.sort(s2subarr);
            String s2subsort = String.valueOf(s2subarr);

            if(s1sort.equals(s2subsort)){
                return true;
            }
        }
        return false;
    }
}
