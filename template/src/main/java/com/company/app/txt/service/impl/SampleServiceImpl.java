package com.company.app.txt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.txt.mapper.Sample1Mapper;
import com.company.app.txt.mapper.Sample2Mapper;
import com.company.app.txt.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	Sample1Mapper mapper1;
	
	@Autowired
	Sample2Mapper mapper2;
	
	@Override
	public void addData(String data1, String data2) {
		mapper1.insertCol1(data1);
		mapper2.insertCol2(data2);
	}

}
