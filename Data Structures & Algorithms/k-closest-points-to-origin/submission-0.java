class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int[][] res = new int[k][2];

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

            int dist = (x * x) + (y * y);

            if(i < k){
                pq.add(new int[]{dist, x, y});
            }
            else{
                if(pq.peek()[0] > dist){
                    pq.remove();
                    pq.add(new int[]{dist, x, y});
                }
            }

        }

        for(int i = 0; i < k; i++){
            int[] arr = pq.remove();
            res[i][0] = arr[1];
            res[i][1] = arr[2];
        }

        return res;

    }
}
