class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int freq;

        public Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair o){
            return Integer.compare(this.freq, o.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int num : map.keySet()){
            if(pq.size() < k){
                pq.add(new Pair(num, map.get(num)));
            }
            else{
                Pair top = pq.peek();
                if(top.freq < map.get(num)){
                    pq.remove();
                    pq.add(new Pair(num, map.get(num)));
                }
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.remove().num;
        }

        return result;

    }
}
