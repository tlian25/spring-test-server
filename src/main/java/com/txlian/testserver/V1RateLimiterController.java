package com.txlian.testserver;

import com.txlian.testserver.exceptions.RateExceededException;
import com.txlian.testserver.util.KeyHelper;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.commands.JedisCommands;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

@RestController
public class V1RateLimiterController {

    @Autowired
    @Qualifier("Redis")
    private JedisCommands jedis;

    private final Map<String, Long> usage = new HashMap<>();

    private final static Long RATE_LIMIT = 20L;
    private Logger log = LoggerFactory.getLogger(V1RateLimiterController.class);



    @GetMapping("/v1/ping")
    public String ping(HttpServletRequest request) {
        long currSec = Clock.systemUTC().millis() / 1000;
        String key = KeyHelper.createRateBucketRedisKey(request.getRemoteAddr(), currSec);
        log.info("Success: {}", key);
        usage.merge(key, 1L, Long::sum);
        return "pong";
    }

    @GetMapping("/v1/ratelimited/ping")
    public String ping_rateLimited(HttpServletRequest request) {
        // Get current minute bucket
        long currSec = Clock.systemUTC().millis() / 1000;
        String key = KeyHelper.createRateBucketRedisKey(request.getRemoteAddr(), currSec);

        // Make a call to redis for given minute
        String res = jedis.get(key);
        long count = StringUtils.isBlank(res) ? 0 : Long.valueOf(res);
        if (count >= RATE_LIMIT) {
            log.warn("Rate exceeded. Blocking request from {}", request.getRemoteAddr());
            throw new RateExceededException();
        }
        jedis.incr(key);
        jedis.expire(key, 5);

        // If not rate limited, track request count in usage
        log.info("Success: {}", key);
        usage.merge(key, 1L, Long::sum);
        return "pong";
    }

    @GetMapping("/v1/usage")
    public Map<String, Long> getUsage() {
        return usage;
    }
}
