package com.dark.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**  ���ߣ����ڱ� 
*    ���ڣ�2018��3��23�� ����9:43:33
*/
public class Hello implements Job{
public static void main(String[] args) {
	System.out.println("��ã�����");	
}

@Override
public void execute(JobExecutionContext arg0) throws JobExecutionException {
	// TODO Auto-generated method stub
	System.out.println("��ã�execute����");	
}
}
