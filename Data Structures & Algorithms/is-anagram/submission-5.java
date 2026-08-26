class Solution {
    public boolean isAnagram(String s, String t) {
        //Solution-4 : Fixed size array arr[26] as hash table

        if(s.length() != t.length()){
            return false;
        }

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            arr[ch1 - 'a']++;
            arr[ch2 - 'a']--;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
