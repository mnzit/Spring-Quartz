package com.mnzit;

import com.mnzit.jobs.TokenJob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.quartz.JobExecutionException;
import org.quartz.impl.JobExecutionContextImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SpringSchedulerApplicationTests {

    @Mock
    private TokenJob tokenJob;

    @Mock
    private JobExecutionContextImpl ctx;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void isCalled() throws JobExecutionException {
        tokenJob.execute(ctx);
        Mockito.verify(tokenJob, Mockito.times(1)).fetchToken();
    }
}
