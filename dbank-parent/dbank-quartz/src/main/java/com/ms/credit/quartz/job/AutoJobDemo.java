package com.ms.credit.quartz.job;

import com.ms.credit.quartz.service.AutoJobDemoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/22 11:37
 */
@Component
public class AutoJobDemo extends QuartzJobBean {
    @Autowired
    private AutoJobDemoService autoJobDemoService;

    /**
     * 定时执行的任务
     *
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String bechTime = "18:03";
        String time = new SimpleDateFormat("HH:mm").format(new Date()).toString();
        if(time.substring(0,1).equals("0")){
            time = time.substring(1,time.length()+1);
        }
        if(time.equals(bechTime)) {
            System.out.println(bechTime +"="+time);
            autoJobDemoService.execute(fileName);
        }
    }
}
