class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];

        return quickSelect(points, k - 1, 0, points.length - 1, res);
    }

    public int[][] quickSelect(int[][] points, int k, int lo, int hi, int[][] res){
        //for k = 0, edge case
        if(lo > hi){
            return new int[][]{}; //empty 2d arr []
        }
        int[] pivotPoint = points[hi];
        int x = pivotPoint[0];
        int y = pivotPoint[1];

        int pivot = (x * x) + (y * y);

        int pivotIndex = partition(points, lo, hi, pivot);

        if(pivotIndex == k){
            for(int i = 0; i <= k; i++){
                res[i][0] = points[i][0];
                res[i][1] = points[i][1];
            }
            return res;
        }
        else if(pivotIndex < k){
            return quickSelect(points, k, pivotIndex + 1, hi, res);
        }
        else{
            return quickSelect(points, k, lo, pivotIndex - 1, res);
        }

    }

    public int partition(int[][] points, int lo, int hi, int pivot){
        int i = lo;
        int j = lo;

        while(i <= hi){
            int[] point = points[i];
            int x = point[0];
            int y = point[1];

            int dist = (x * x) + (y * y);

            if(dist > pivot){
                i++;
            }
            else{
                int[] temp = points[j];
                points[j] = points[i];
                points[i] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }
}
