class Twitter {
    /*
    represents all of twitter, so it holds all users and follwers/followees and what not
    hashmap of userid to list of integer of userids of the people they are following
    hashmap of userid to maxheap of posts made by them or people they are following

    */
    /*
    HashMap<Integer, ArrayList<Integer>> userToFollowers;
    HashMap<Integer, PriorityQueue<Integer>> userToFeed;
    */
    int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        /*
        userToFeed = new HashMap<>();
        userToFollowers = new HashMap<>();
        */

        count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        /*
        userToFeed.put(userId, userToFeed.getOrDefault(userId, new ArrayList<Integer>().add(tweetId)));
        for (int i : userToFollowers.get(userId)) {
            userToFeed.getOrDefault(i, new ArrayList<Integer>()).add(tweetId);
        }
        */
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{count, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--; // more recent
    }
    
    public List<Integer> getNewsFeed(int userId) {
        /*
        List<Integer> feed = new ArrayList<Integer>();
        PriorityQueue<Integer> allPosts = userToFeed.getOrDefault(userId, new PriorityQueue<>());
        for (int i = 0; i < 10; i++) {
            if (allPosts.isEmpty()) {
                break;
            }
            feed.add(allPosts.poll());
        }
        return feed;
        */
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        if (followMap.get(userId).size() >= 10) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );
            for (int followeeId : followMap.get(userId)) {
                if (!tweetMap.containsKey(followeeId)) continue;
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{-tweet[0], tweet[1], followeeId, index - 1});
                if (maxHeap.size() > 10) {
                    maxHeap.poll();
                }
            }
            while (!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                minHeap.offer(new int[]{-top[0], top[1], top[2], top[3]});
            }
        } else {
            for (int followeeId : followMap.get(userId)) {
                if (!tweetMap.containsKey(followeeId)) continue;
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index - 1});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] top = minHeap.poll();
            res.add(top[1]);
            int nextIndex = top[3];
            if (nextIndex >= 0) {
                List<int[]> tweets = tweetMap.get(top[2]);
                int[] nextTweet = tweets.get(nextIndex);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIndex - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        // userToFollowers.put(followeeId, userToFollowers.getOrDefault(foloweeId, new ArrayList<Integer>()).add(followerId));
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // userToFollowers.put(followeeId, userToFollowers.getOrDefault(foloweeId, new ArrayList<Integer>()).remove(followerId));
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
