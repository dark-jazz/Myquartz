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

/**  ���ߣ����ڱ� 
*    ���ڣ�2018��3��23�� ����10:03:31
*/
public class QuartzReptileRun {
    
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		   //����
	      JobDetail jobDetail=JobBuilder.newJob(TestQuartzReptile.class).withIdentity("job1","group1").build();
	
	      
	    /*    //2������������
	      SimpleTrigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1", "group2")
	    		  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(3))
	    		  .startAt(new Date()).build();*/
	      //2������������,ʵ��ÿ������12����ȡһ������
	      CronTrigger trigger2=TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
	    		  .withSchedule(CronScheduleBuilder.cronSchedule("0 6 11 * * ?"))
	    		  .startAt(new Date()).build();
 
	        //3����������Ա
	      Scheduler sch=new StdSchedulerFactory().getDefaultScheduler();
	      
	      
	        //4��ע������
	      sch.scheduleJob(jobDetail,trigger2);
	      
	      System.out.println("����ʼִ��");
	      sch.start();
	   /*   Thread.sleep(500000);
	      sch.shutdown(true);
	      System.out.println("����ִ�����");*/
	      
	}
	
	
	
	
}
