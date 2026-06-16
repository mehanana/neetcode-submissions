class Twitter {
    HashMap<Integer, List<int[]>> userToTweets;
    HashMap<Integer, Set<Integer>> userToFollowees;
    int time;

    public Twitter() {
        userToTweets = new HashMap<>();
        userToFollowees = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userToTweets.computeIfAbsent(userId, k -> new ArrayList<>())
                    .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // own tweets
        for (int[] entry : userToTweets.getOrDefault(userId, new ArrayList<>())) {
            feed.offer(entry);
            if (feed.size() > 10) feed.poll();
        }
        // followees' tweets — skip self to avoid double-counting
        for (Integer followee : userToFollowees.getOrDefault(userId, new HashSet<>())) {
            if (followee == userId) continue;
            for (int[] entry : userToTweets.getOrDefault(followee, new ArrayList<>())) {
                feed.offer(entry);
                if (feed.size() > 10) feed.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!feed.isEmpty()) res.add(feed.poll()[1]);
        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        userToFollowees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = userToFollowees.get(followerId);
        if (set != null) set.remove(followeeId);
    }
}