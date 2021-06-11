package com.mnzit.jobs;

import com.mnzit.store.TokenStore;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;


public class TestJob extends QuartzJobBean {

    private TokenStore tokenStore;

    public void setTokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date());
        System.out.println(tokenStore);
    }

}
