package com.dark.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**  作者：钟宗斌 
*    日期：2018年3月23日 上午9:43:33
*/
public class Hello implements Job{
public static void main(String[] args) {
	System.out.println("你好，天天");	
}

@Override
public void execute(JobExecutionContext arg0) throws JobExecutionException {
	// TODO Auto-generated method stub
	System.out.println("你好，execute方法");	
}
}
