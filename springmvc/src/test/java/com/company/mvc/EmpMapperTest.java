package com.company.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
// container 구성
@ContextConfiguration(locations = "file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class EmpMapperTest {
	
	// 컨테이너로부터 필요한 파일 주입 받음
	@Autowired EmpMapper mapper;
	
	// JUNIT test
	@Test
	public void test() {
		EmpVO param = new EmpVO();
		param.setEmployee_id("100");
		EmpVO result = mapper.getEmp(param);
		System.out.println(result);
		System.out.println(result.getFirst_name());
	}
// Java Application Test	
//	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
//		EmpMapper mapper = ctx.getBean(EmpMapper.class);
//		EmpVO param = new EmpVO();
//		param.setEmployee_id("100");
//		EmpVO result = mapper.getEmp(param);
//		System.out.println(result.getFirst_name());
//	}
}