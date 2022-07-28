package com.company.app.emp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.mapper.EmpVO;

@SpringBootTest
public class EmpApplicationTest {
	
	@Autowired EmpMapper mapper;
	
	//@Test
	public void listTest() {
		EmpVO vo = new EmpVO();
		List<EmpVO> list = mapper.getEmpList(vo);
		for (EmpVO emp : list) {
			System.out.println(emp.toString());
		}
	}
	
	@Test
	public void empTest() {
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("240");
		System.out.println(mapper.getEmp(vo).toString());
	}

}
