package com.txlian.testserver.data;

import com.txlian.testserver.identifier.IdGeneratorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TinyUrlDOFactory {

    @Autowired
    @Qualifier("IdGeneratorStrategy")
    private IdGeneratorStrategy strategy;

    public TinyUrlDO generateTinyUrlDO(String url) {
        Long currtime = System.currentTimeMillis();
        String id = strategy.generateId();
        TinyUrlDO tinyUrlDO = new TinyUrlDO();
        tinyUrlDO.setId(id);
        tinyUrlDO.setOriginalUrl(url);
        tinyUrlDO.setTimestamp(currtime);
        return tinyUrlDO;
    }
}
