package com.txlian.testserver.data;

import java.util.List;

public interface UrlDAO {
    String saveTinyUrl(TinyUrlDO tinyUrlDO);
    String saveTinyUrl(String originalUrl);
    TinyUrlDO getTinyUrl(String id);

    List<TinyUrlDO> getAllUrls();
}
