package com.txlian.testserver;

import com.txlian.testserver.data.LocalStorageDAO;
import com.txlian.testserver.data.TinyUrlDOFactory;
import com.txlian.testserver.data.UrlDAO;
import com.txlian.testserver.identifier.FriendlyIdGeneratorStrategy;
import com.txlian.testserver.identifier.IdGeneratorStrategy;
import com.txlian.testserver.util.LocalJedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.commands.JedisCommands;

@Configuration
public class Config {

    @Bean("TinyUrlStorage")
    public UrlDAO getUrlDAO() {
        return new LocalStorageDAO();
    }

    @Bean("TinyUrlDOFactory")
    public TinyUrlDOFactory getFactory() {
        return new TinyUrlDOFactory();
    }

    @Bean("IdGeneratorStrategy")
    public IdGeneratorStrategy getStrategy() {
        // return new SimpleIdGeneratorStrategy();
        return new FriendlyIdGeneratorStrategy();
    }

    @Bean("Redis")
    public JedisCommands getJedis() {
        return new JedisPooled("localhost", 6379);
    }

    @Bean("LocalRedis")
    public JedisCommands getLocalJedis() {
        return new LocalJedis();
    }

}
