package com.wisely.highlight_spring4.ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 1、通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
 * 2、使用cron属性可按照指定时间执行，本例指的是每天20点30分执行；
 * cron是UNIX和类UNIX（Linux）系统下的定时任务。
 * @author Mask
 *
 */
@Service
public class ScheduledTaskService {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("每隔五秒钟执行一次 " + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "0 30 20 ? * *" )
	public void fixTimeExecution() {
		System.out.println("在指定时间 " + dateFormat.format(new Date()));
	}
}
