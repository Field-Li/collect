package com.collect.quartz;

/**
 * Created by lifana on 2017/7/27.
 */
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobA implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Job A is runing");
    }

}