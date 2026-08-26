class Solution {
    public boolean isAnagram(String s, String t) {
        //Solution-4 : Fixed size array arr[26] as hash table

        if(s.length() != t.length()){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            arr1[ch1 - 'a']++;
            arr2[ch2 - 'a']++;
        }

        return Arrays.equals(arr1, arr2);
    }
}
