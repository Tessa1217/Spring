package com.company.app.txt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.txt.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
public class SampleServiceTest {
	
	@Autowired SampleService service;
	
	@Test
	public void sampleTest() {
		String str1 = "Hello";
		String str2 = "Hello everyone";
		service.addData(str1, str2);
	}
	
}
