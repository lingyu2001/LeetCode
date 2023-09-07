class Twitter {
    int time;
    Map<Integer, HashSet<Integer>> mapFollowee;
    Map<Integer, List<int[]>> mapTweet;
    
    public Twitter() {
        time = 0;
        mapFollowee = new HashMap<>();
        mapTweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        mapTweet.computeIfAbsent(userId, k -> new ArrayList<>());
        mapTweet.computeIfPresent(userId, (k, v) -> {
            v.add(new int[]{time, tweetId});
            return v;
        });
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = mapFollowee.computeIfAbsent(userId, k-> new HashSet<>());
        set.add(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int id : set) {
            if (mapTweet.containsKey(id)) {
                int i = mapTweet.get(id).size() - 1;
                int[] tweet = mapTweet.get(id).get(i);
                pq.offer(new int[]{tweet[0], tweet[1], id, --i});
            }
        }
        while(!pq.isEmpty() && res.size() < 10) {
            int[] tweet = pq.poll();
            res.add(tweet[1]);
            if (tweet[3] >= 0) {
                int[] newTweet = mapTweet.get(tweet[2]).get(tweet[3]);
                pq.offer(new int[] {newTweet[0], newTweet[1],tweet[2],tweet[3] - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        mapFollowee.computeIfAbsent(followerId, k -> new HashSet<>());
        mapFollowee.computeIfPresent(followerId,(k,v) -> {
            v.add(followeeId);
            return v;
        });
    }
    
    public void unfollow(int followerId, int followeeId) {
        mapFollowee.computeIfAbsent(followerId, k -> new HashSet<>());
        mapFollowee.computeIfPresent(followerId, (k,v) -> {
            v.remove(followeeId); 
            return v;
        });
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */