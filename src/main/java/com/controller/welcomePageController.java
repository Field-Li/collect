package com.controller;

import com.collect.quartz.HelloJob;
import com.common.utils.SpringContextUtil;
import com.mysql.mapper.ProductMapper;
import com.mysql.service.impl.ProductServiceImp;
import com.rits.cloning.Cloner;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifana on 2017/2/4.
 */
@Controller
public class welcomePageController {
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        Cloner cloner = new Cloner();
        cloner.deepClone(ProductServiceImp.class);


        Long productId = 112255L;
        String ownerid = "ss";

        ProductServiceImp service = (ProductServiceImp) SpringContextUtil.getBean("productServiceImp");
//        String ss = service.getProduct(productId);
        int test = service.updateByProductId(productId);
        Map map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMDD HH-MM-SS");
        String date = sdf.format(new Date());
        map.put("jobName", "HelloJob");
        map.put("groupName", "HelloGroup");
        map.put("time", date);
        return new ModelAndView("index", map);
    }

    @RequestMapping("/trigger")
    public void triggerJobMannual() throws Exception {
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("dummyJobName", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        //schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
