package com.txlian.testserver.data;

import lombok.Data;

@Data
public class TinyUrlDO {
    private String id;
    private String originalUrl;
    private Long timestamp;
}
