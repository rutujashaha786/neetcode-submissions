class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
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

                j = i + 1;
                i = j + len;

                String word = str.substring(j, i);
                res.add(word);
                j = i;
            }
        }

        return res;
    }
}
