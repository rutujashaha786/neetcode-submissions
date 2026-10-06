class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;

        for(int a : piles){
            max = Math.max(max, a);
        }

        int i = 1;
        int j = max;

        int k = -1;

        while(i <= j){
            int mid = (i + j) / 2; //k

            double total = 0;

            for(int m = 0; m < n; m++){
                total += Math.ceil((double)piles[m] / mid); //0. 2, 1
            }

            if(total <= h){
                k = mid;
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }

        }

        return k;
    }
}
