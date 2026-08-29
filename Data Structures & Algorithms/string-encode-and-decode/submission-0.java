class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for(String str : strs){
            res = res + str.length() + "#" + str;
        }
        return res;
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> res = new ArrayList<>();

       // length#string

        int i = 0;
        int j = 0;
        while(i < n){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                i++;
            }
            else if(ch == '#'){
                String length = str.substring(j, i);
                int len = Integer.parseInt(length);
                String word = str.substring(i+1, i+len+1);
                res.add(word);
                i = i + len + 1;
                j = i;
            }
        }

        return res;
    }
}
