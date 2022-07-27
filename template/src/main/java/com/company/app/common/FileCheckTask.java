package com.company.app.common;

import org.springframework.stereotype.Component;

@Component
public class FileCheckTask {
	// cron (sec min hr day month dayofweek)
	//@Scheduled(fixedRate = 5000)
	public void checkFile() {
		System.out.println("task run");
	}
}
