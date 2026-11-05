class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Math based solution - get max freq and maxfreqcount & draw structure
        //Suppose 2 chars (A, B) with maxFreq = 3, cooldown. = 2
        //for last group, dont add idle
        //A B - | A B - | A B
        //full groups with cooldown = (maxfreq  - 1) * (cooldown + 1)
        //last section as more than 1 maxfreq nums = maxfreqCount
        //Time = 8
        //Nuance = A B C | A B D | A B E
        //total = 9 tasks
        //Hence Math.max(time, tasks.length)

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        int maxFreq = 0;
        int maxFreqCount = 0;
        for(char key : map.keySet()){
            int freq = map.get(key);
            if(freq > maxFreq){
                maxFreq = freq;
                maxFreqCount = 1; //reset
            }
            else if(freq == maxFreq){
                maxFreqCount++;
            }
        }

        //math logic
        int time = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(time, tasks.length);
    }
}
