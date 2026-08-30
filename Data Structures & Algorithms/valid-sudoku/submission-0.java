class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();

        HashMap<String, HashSet<Character>> boxMap = new HashMap<>();

        //init row/col maps with 0-9 as keys
        for(int i = 0; i < 9; i++){
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
        }

    //init boxMaps with 0,0 || 0,1 || 0,2 || 1,0 || 1,1 || 1,2 || 2,0 || 2,1 || 2,2
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            String key = i + "," + j;
            boxMap.put(key, new HashSet<>());
        }
    }


        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];

                if(ch == '.'){
                    continue;
                }

                String boxKey = (r / 3) + "," + (c / 3);

                if(rowMap.get(r).contains(ch) || 
                colMap.get(c).contains(ch) || 
                boxMap.get(boxKey).contains(ch)){
                    return false;
                }

                rowMap.get(r).add(ch);
                colMap.get(c).add(ch);
                boxMap.get(boxKey).add(ch);
            }
        }

        return true;
    }
}
