package com.mnzit.jobs;

import com.mnzit.service.TokenEnum;
import com.mnzit.service.TokenStore;
import com.mnzit.service.TokenWebService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;


public class TokenJob extends QuartzJobBean {

    private TokenStore tokenStore;
    private TokenWebService tokenWebService;

    public void setTokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    public void setTokenWebService(TokenWebService tokenWebService) {
        this.tokenWebService = tokenWebService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Called");
        System.out.println(jobExecutionContext.get("tokenStore"));
        System.out.println(jobExecutionContext.get("asd"));
//        LocalDateTime currentDateTime = LocalDateTime.now();
//
//        LocalDateTime lastRefreshTime = tokenStore.get(TokenEnum.LAST_REFRESH_TIME) != null ? null :
//                (LocalDateTime) tokenStore.get(TokenEnum.LAST_REFRESH_TIME);
//        LocalDateTime nextRefreshTime = tokenStore.get(TokenEnum.NEXT_REFRESH_TIME) != null ? null :
//                (LocalDateTime) tokenStore.get(TokenEnum.NEXT_REFRESH_TIME);     //1:00
//        LocalDateTime forcedTime = getForcedRefreshTime();
//
//        // First Load Everything is null
//        if (lastRefreshTime != null && nextRefreshTime != null) {
//
//            Boolean isExpired = currentDateTime.isAfter(nextRefreshTime);
//            LocalDateTime addThirtyMinToCurrentTime = currentDateTime.plusMinutes(30); // 12:30
//            Boolean willExpireBeforeNextLookUp = addThirtyMinToCurrentTime.isBefore(nextRefreshTime);
//            Boolean isCurrentGreaterThenAfterForceRefreshTime = currentDateTime.isAfter(forcedTime);
//
//            if (isExpired || willExpireBeforeNextLookUp || isCurrentGreaterThenAfterForceRefreshTime) {
//                fetchToken();
//            }
//        } else {
        fetchToken();
//        }
    }

    public void fetchToken() {
        LocalDateTime createdTime = LocalDateTime.now();
        LocalDateTime expiryTime = createdTime.plusMinutes(30);
        String token = tokenWebService.getToken();
        System.out.println("Token : " + token);

        tokenStore.setTokenDetail(TokenEnum.TOKEN, token);
        tokenStore.setTokenDetail(TokenEnum.LAST_REFRESH_TIME, createdTime);
        tokenStore.setTokenDetail(TokenEnum.NEXT_REFRESH_TIME, expiryTime);
    }

    private LocalDateTime getForcedRefreshTime() {
        String forcedTs = "2021-21-15T21:54:01.905";
        LocalDateTime forcedTime = null;
        try {
            forcedTime = LocalDateTime.parse(forcedTs);
        } catch (Exception e) {}
        return forcedTime;
    }
}
