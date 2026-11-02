class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char key : map.keySet()){
            pq.add(map.get(key));
        }

        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            //queue peek - if matching with time, add it
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.remove()[0]);
            }

            if(!pq.isEmpty()){
                int mostFreq = pq.remove();
                time++;

                int updateFreq = mostFreq - 1;
                if(updateFreq >= 1){
                    q.add(new int[]{updateFreq, time + n}); //not time + n + 1
                }
            }
            else if(!q.isEmpty()){
                time++;
            }     
        }

        return time;


    }
}
