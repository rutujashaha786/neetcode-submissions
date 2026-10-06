class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);

        int lo = 0;
        int hi = list.size() - 1;

        String res = "";

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(list.get(mid).time <= timestamp){
                res = list.get(mid).value;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }       
        }

        return res;

    }
}

class Pair{
    String value;
    int time;

    public Pair(String value, int time){
        this.value = value;
        this.time = time;
    }
}
