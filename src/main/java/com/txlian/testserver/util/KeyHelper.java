package com.txlian.testserver.util;

public class KeyHelper {


    public static String createRateBucketRedisKey(long currSec) {
        return String.valueOf(currSec);
    }

    public static String createRateBucketRedisKey(String remoteIp, long currSec) {
        return String.format("%s:%s", remoteIp, currSec);
    }

    public static String createUserScoreRedisKey(String userId) {
        return userId;
    }
}
