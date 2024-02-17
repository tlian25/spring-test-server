package com.txlian.testserver.identifier;

import java.util.UUID;

public class SimpleIdGeneratorStrategy implements IdGeneratorStrategy {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
