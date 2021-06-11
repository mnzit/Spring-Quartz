package com.mnzit.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenStore {

    Map<String, Object> tokenDetail = new ConcurrentHashMap<>();

    public Object get(String key) {
        return this.tokenDetail.get(key);
    }

    public void setTokenDetail(String key, Object value) {
        this.tokenDetail.put(key, value);
    }
}
