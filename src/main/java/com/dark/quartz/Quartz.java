package com.dark.quartz;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**  ���ߣ����ڱ� 
*    ���ڣ�2018��3��23�� ����9:43:17
*/
public class Quartz {
public static void main(String[] args) throws SchedulerException, InterruptedException {
	        //����
	      JobDetail jobDetail=JobBuilder.newJob(Hello.class).withIdentity("job1","group1").build();
	
	      
	        //2������������
	      SimpleTrigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1", "group2")
	    		  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(-1))
	    		  .startAt(new Date()).build();
	      
	        //3����������Ա
	      Scheduler sch=new StdSchedulerFactory().getDefaultScheduler();
	      
	      
	        //4��ע������
	      sch.scheduleJob(jobDetail,trigger);
	      
	      System.out.println("����ʼִ��");
	      sch.start();
	      Thread.sleep(500000);
	     
	      sch.shutdown(true);
	      System.out.println("����ִ�����");
	      
}     

	
}
