class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];

        //make pair(position, speed)
        for(int i = 0; i < n; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        //sort pair based on position
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        //processing in sort sequence by calculating && comparing time 
        double maxTime = Double.NEGATIVE_INFINITY;
        int count = 0;

        for(int i = 0; i < n; i++){
            double time = (double)(target - arr[i][0]) / arr[i][1];

            if(maxTime < time){
                maxTime = time;
                count++;
            }
        }

        return count;
    }
}
