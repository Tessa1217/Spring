package com.company.app.emp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.service.DepartmentVO;
import com.company.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
public class EmpMapperTest {
	
	@Autowired EmpMapper mapper;
	
	@Test
	public void test() {
		//System.out.println(mapper.getDeptEmp(new DepartmentVO()));
		List<DepartmentVO> deptList = mapper.getDeptEmp(new DepartmentVO());
		for (DepartmentVO dept : deptList) {
			System.out.println("===========================");
			System.out.println("부서 아이디: " + dept.getDepartmentId());
			System.out.println("부서 이름: " + dept.getDepartmentName());
			System.out.println("해당 부서에 속해있는 사람들");
			for (EmpVO emp : dept.getEmps()) {
				System.out.println(emp.getEmployeeId() + ", " + emp.getFirstName());
			}
			System.out.println("===========================");
		}
	}

}
