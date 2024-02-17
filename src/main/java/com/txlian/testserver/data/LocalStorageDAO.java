package com.txlian.testserver.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalStorageDAO implements UrlDAO {

    @Autowired
    @Qualifier("TinyUrlDOFactory")
    private TinyUrlDOFactory tinyUrlDOFactory;

    private Map<String, TinyUrlDO> map = new ConcurrentHashMap<>();

    @Override
    public String saveTinyUrl(String originalUrl) {
        TinyUrlDO tinyUrlDO = tinyUrlDOFactory.generateTinyUrlDO(originalUrl);
        return saveTinyUrl(tinyUrlDO);
    }

    @Override
    public String saveTinyUrl(TinyUrlDO tinyUrlDO) {
        map.put(tinyUrlDO.getId(), tinyUrlDO);
        return tinyUrlDO.getId();
    }

    @Override
    public TinyUrlDO getTinyUrl(String id) {
        return map.get(id);
    }

    @Override
    public List<TinyUrlDO> getAllUrls() {
        return map.values().stream().toList();
    }
}
