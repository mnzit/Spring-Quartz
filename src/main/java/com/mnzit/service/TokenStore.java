package com.mnzit.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenStore {

    Map<TokenEnum, Object> tokenDetail = new ConcurrentHashMap<>();

    @Autowired
    private TokenWebService tokenWebService;

    public Object getKey() {

        String token = (String) this.tokenDetail.get(TokenEnum.TOKEN);

        if (token == null) {
            token = tokenWebService.getToken();
            LocalDateTime createdTime = LocalDateTime.now();
            LocalDateTime expiryTime = createdTime.plusMinutes(30);
            setTokenDetail(TokenEnum.TOKEN, token);
            setTokenDetail(TokenEnum.LAST_REFRESH_TIME, createdTime);
            setTokenDetail(TokenEnum.NEXT_REFRESH_TIME, expiryTime);
        }

        return token;
    }

    public Object get(TokenEnum key) {
        return this.tokenDetail.get(key);
    }

    public void setTokenDetail(TokenEnum key, Object value) {
        this.tokenDetail.put(key, value);
    }
}
