class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        //get freq of s1 & 1st window in s2 using 26 arr
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        //check that 1st build arrys are matching by incremening matches array
        //if matches == 26, means all chars freq matched, true

        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1Count[i] == s2Count[i]){
                matches++;
            }
        }

        for(int i = s1.length(); i < s2.length(); i++){
            if(matches == 26){
                return true;
            }

            //acquire
            s2Count[s2.charAt(i) - 'a']++;
            if(s1Count[s2.charAt(i) - 'a'] == s2Count[s2.charAt(i) - 'a']){
                matches++;
            }
            else if(s1Count[s2.charAt(i) - 'a'] + 1 == s2Count[s2.charAt(i) - 'a']){
                matches--;
            }

            //release
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            if(s1Count[s2.charAt(i - s1.length()) - 'a'] == s2Count[s2.charAt(i - s1.length()) - 'a']){
                matches++;
            }
            else if (s1Count[s2.charAt(i - s1.length()) - 'a'] - 1 == s2Count[s2.charAt(i - s1.length()) - 'a']){
                matches--;
            }

        }

        return matches == 26;
     

    }
}
