package com.txlian.testserver.identifier;

import com.devskiller.friendly_id.FriendlyId;

public class FriendlyIdGeneratorStrategy implements IdGeneratorStrategy {

    @Override
    public String generateId() {
        return FriendlyId.createFriendlyId();
    }
}
