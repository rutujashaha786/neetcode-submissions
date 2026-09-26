class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>();
        for(int i = 0; i < tokens.length; i++){
            tokenList.add(tokens[i]);
        }
        return dfs(tokenList);
    }

    public int dfs(List<String> tokenList){
        String token = tokenList.remove(tokenList.size()-1);

        if(!"+-*/".contains(token)){
            return Integer.parseInt(token);
        }

        int right = dfs(tokenList);
        int left = dfs(tokenList);

        switch(token){
            case "+" : 
                return left + right;
            case "-" : 
                return left - right;
            case "*" : 
                return left * right;
            case "/" : 
                return left / right;
        }
        return 0;
    }
}
