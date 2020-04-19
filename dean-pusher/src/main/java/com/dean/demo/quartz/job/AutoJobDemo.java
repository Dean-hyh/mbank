package com.dean.demo.quartz.job;

import com.dean.demo.quartz.service.AutoJobDemoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/22 11:37
 */
@Component
public class AutoJobDemo extends QuartzJobBean {

    @Resource private AutoJobDemoService autoJobDemoService;

    /**
     * 定时执行的任务
     *
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String bechTime = "17:52";
            String time = new SimpleDateFormat("HH:mm").format(new Date()).toString();
            if(time.substring(0,1).equals("0")){
                time = time.substring(1,time.length()+1);
            }
            if(time.equals(bechTime)) {
                System.out.println(bechTime +"="+time);
                autoJobDemoService.execute(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("跑批任务执行失败。。。");
        }
    }
}
