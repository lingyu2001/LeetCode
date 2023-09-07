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
            List<int[]> tweets = mapTweet.get(id);
            if (tweets != null)
                for(int[] tweet: tweets) {
                    pq.offer(tweet);
                }
        }
        if (pq.size() >= 10)
            for (int i = 0; i < 10; i++) {
                res.add(pq.poll()[1]);
            }
        else {
            while (!pq.isEmpty()) {
                res.add(pq.poll()[1]);
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