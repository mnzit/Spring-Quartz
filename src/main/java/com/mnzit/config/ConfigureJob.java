package com.mnzit.config;

import com.mnzit.jobs.TestJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(TestJob.class).withIdentity("sampleJobA")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {
        return TriggerBuilder.newTrigger().forJob(jobADetails)

                .withIdentity("sampleTriggerA")
                // online cron expression generator
                // https://www.freeformatter.com/cron-expression-generator-quartz.html
                // fire event every 5 seconds
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * ? * * *"))
                .build();
    }
}
