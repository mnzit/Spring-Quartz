package com.mnzit.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.ZonedDateTime;

public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Scheduler output: " + ZonedDateTime.now().toString());
    }
}
