package com.dean.demo.quartz.service;

import com.dean.demo.quartz.monitor.IMonitorJob;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/22 13:41
 */
@Service("commTaskService")
public class CommTaskService {
    /**
     * 监控执行类
     *
     * @param job
     * @param context
     */
    public void executeJob(IMonitorJob job, JobExecutionContext context) {
        job.executeJob();
    }

    public void executeJob(IMonitorJob job) {
        job.executeJob();
    }
}
