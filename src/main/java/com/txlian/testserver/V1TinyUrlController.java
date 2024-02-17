package com.txlian.testserver;

import com.txlian.testserver.data.TinyUrlDO;
import com.txlian.testserver.data.UrlDAO;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class V1TinyUrlController {

    private static final String version = "v1";

    @Autowired
    @Qualifier("TinyUrlStorage")
    private UrlDAO tinyUrlDAO;

    private Logger log = LoggerFactory.getLogger(V1TinyUrlController.class);

    @GetMapping("/v1/urls/{tinyurl}")
    public String getUrl(@PathVariable String tinyurl) throws IllegalArgumentException {
        TinyUrlDO tinyUrlDO = tinyUrlDAO.getTinyUrl(tinyurl);
        if (tinyUrlDO == null) {
            throw new IllegalArgumentException("Tiny url not found");
        }
        log.info("Getting tinyurl {} => {}", tinyurl, tinyUrlDO.getOriginalUrl());
        return tinyUrlDO.getOriginalUrl();
    }

    @PutMapping("/v1/urls/{originalUrl}")
    public String saveUrl(@PathVariable String originalUrl) throws IllegalArgumentException {
        if (StringUtils.isBlank(originalUrl)) {
            throw new IllegalArgumentException("Unable to create TinyURL for blank URL.");
        }
        String tinyurl = tinyUrlDAO.saveTinyUrl(originalUrl);
        log.info("Saving tinyurl {} => {}", originalUrl, tinyurl);
        return tinyurl;
    }

    @GetMapping("/v1/urls")
    public List<TinyUrlDO> getAllUrls() {
        log.info("Getting all URLs");
        return tinyUrlDAO.getAllUrls();
    }
}
