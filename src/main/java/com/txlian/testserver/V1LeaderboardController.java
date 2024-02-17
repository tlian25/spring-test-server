package com.txlian.testserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.resps.Tuple;

import java.util.ArrayList;
import java.util.List;

@RestController
public class V1LeaderboardController {

    @Autowired
    @Qualifier("Redis")
    private JedisCommands jedis;

    private static final String LEADERBOARD = "board";

    private Logger log = LoggerFactory.getLogger(V1LeaderboardController.class);


    @PutMapping("/v1/leaderboard/{userId}")
    public String addScore(@PathVariable String userId) {
        return addScore(userId, 1);
    }

    @PutMapping("/v1/leaderboard/{userId}/{score}")
    public String addScore(@PathVariable String userId, @PathVariable long score) {
        jedis.zincrby(LEADERBOARD, score, userId);
        log.info("Adding score: {} - {}", userId, score);
        return "Success";
    }

    @GetMapping("/v1/leaderboard")
    public List<String> getLeaderboard() {
        List<String> scores = new ArrayList<>();

        for (Tuple t : jedis.zrevrangeWithScores(LEADERBOARD, 0, 9)) {
            scores.add(String.format("%s - %s", t.getElement(), t.getScore()));
        }
        return scores;
    }


}
