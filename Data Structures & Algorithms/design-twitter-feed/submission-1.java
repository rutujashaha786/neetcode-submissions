class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap; //userId -> set(followerIDS)
    HashMap<Integer, List<int[]>> tweetMap; //userID -> List[[time, tweetId]]
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{time, tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        //Careful handling, as even if map not have entry, self post tweet allowed
        HashSet<Integer> followerIdsSet = new HashSet<>();
        if(followMap.containsKey(userId)){//edge case
            // HashSet<Integer> followerIdsSet = followMap.get(userId); //wrong, original gets modified due to self add later
            followerIdsSet.addAll(followMap.get(userId));
        }
        followerIdsSet.add(userId); //edge case: create new hashset with self as followee

        //Initial K handling
        for(int followerId : followerIdsSet){
            if(tweetMap.containsKey(followerId)){ //edge case
                List<int[]> tweekIdsPairList = tweetMap.get(followerId);

                int lastElemntIndex = tweekIdsPairList.size() - 1;
                int time = tweekIdsPairList.get(lastElemntIndex)[0];
                int tweetId = tweekIdsPairList.get(lastElemntIndex)[1];

                pq.add(new int[]{time, tweetId, followerId, lastElemntIndex});
            }
        }

        //Remove largest and put that followerIds next index in pq using removed index
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            int[] recentTweet = pq.remove();
            res.add(recentTweet[1]);
            count++;

            //add next if index available
            int index = recentTweet[3];
            if(index >= 1){
                int followerId = recentTweet[2];
                List<int[]> tweekIdsPairList = tweetMap.get(followerId);

                int time = tweekIdsPairList.get(index-1)[0];
                int tweetId = tweekIdsPairList.get(index-1)[1];

                pq.add(new int[]{time, tweetId, followerId, index-1});
            }    

        }
        

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){ //edge case - folower has nobody followed, no map enrty
            followMap.get(followerId).remove(followeeId); // followerId exists, but followeeId doesn't	- remove() does nothing/no exception
        }
    }
}
