package com.dark.reptile;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.dark.quartz.Hello;
import com.dark.quartz.TestQuartzReptile;

/**  作者：钟宗斌 
*    日期：2018年3月23日 上午10:03:31
*/
public class QuartzReptileRun {
    
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		   //创建
	      JobDetail jobDetail=JobBuilder.newJob(TestQuartzReptile.class).withIdentity("job1","group1").build();
	
	      
	    /*    //2、创建触发器
	      SimpleTrigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1", "group2")
	    		  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(3))
	    		  .startAt(new Date()).build();*/
	      //2、创建触发器,实现每天中午12点爬取一次数据
	      CronTrigger trigger2=TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
	    		  .withSchedule(CronScheduleBuilder.cronSchedule("0 6 11 * * ?"))
	    		  .startAt(new Date()).build();
 
	        //3、创建调度员
	      Scheduler sch=new StdSchedulerFactory().getDefaultScheduler();
	      
	      
	        //4、注册任务
	      sch.scheduleJob(jobDetail,trigger2);
	      
	      System.out.println("任务开始执行");
	      sch.start();
	   /*   Thread.sleep(500000);
	      sch.shutdown(true);
	      System.out.println("任务执行完毕");*/
	      
	}
	
	
	
	
}
