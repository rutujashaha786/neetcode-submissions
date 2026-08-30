class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(!isAlphaNumeric(ch1)){
                i++;
            }
            else if(!isAlphaNumeric(ch2)){
                j--;
            }
            else if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)){
                return false;
            }
            else{
                i++;
                j--;
            }
            
        }
        return true;
    }

    public boolean isAlphaNumeric(char ch){
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
    }
}
