class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = getRow(matrix, target);
        
        if(row == -1){
            return false;
        }

        return binarySearchOnCol(matrix, target, row);
        
    }

    public boolean binarySearchOnCol(int[][] matrix, int target, int row){
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m - 1;

        while(i <= j){
            int mid = (i + j) / 2;

            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        return false;
    }

    public int getRow(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = n - 1;

        int row = -1;

        while(i <= j){
            int mid = (i + j) / 2;

            if(matrix[mid][0] <= target && target <= matrix[mid][m-1]){
                row = mid;
                break;
            }
            else if(target < matrix[mid][0]){
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }

        return row;
    }
}
