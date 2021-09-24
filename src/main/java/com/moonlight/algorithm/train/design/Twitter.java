package com.moonlight.algorithm.train.design;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/design-twitter/
 *
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *     postTweet(userId, tweetId): 创建一条新的推文
 *     getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 *     follow(followerId, followeeId): 关注一个用户
 *     unfollow(followerId, followeeId): 取消关注一个用户
 *
 * Twitter twitter = new Twitter();
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 */
public class Twitter {

    private Map<Integer, User> userMap;
    private List<Tweet> tweetList;

    public Twitter() {
        userMap = new HashMap<>(16);
        tweetList = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        Tweet tweet = new Tweet(tweetId, userId);
        tweetList.add(tweet);
    }

    public List<String> getNewsFeed(int userId) {
        List<String> ans = new ArrayList<>();
        if (userMap.containsKey(userId)) {
            int cnt = 0;
            for (int i = tweetList.size() - 1; i >= 0 && cnt < 10; i--){
                Tweet tweet = tweetList.get(i);
                if (tweet.userId == userId) {
                    ans.add(String.valueOf(tweet.tweetId));
                    cnt++;
                    continue;
                }
                for (Integer followerId : userMap.get(userId).followers) {
                    if (tweet.userId == followerId) {
                        ans.add(String.valueOf(tweet.tweetId));
                        cnt++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User followerUser = userMap.get(followerId);
        followerUser.followers.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User user = userMap.get(followerId);
        List<Integer> list = user.followers;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == followeeId) {
                list.remove(i);
                break;
            }
        }
    }

    private static class User {
        int userId;
        List<Integer> followers;

        User(int userId) {
            this.userId = userId;
            followers = new ArrayList<>();
        }
    }

    private static class Tweet {
        int tweetId;
        int userId;

        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

}
