package com.company.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentVO {
	
	 private String departmentId;
	 private String departmentName;
	 private String managerId;
	 private String locationId;
	 private List<EmpVO> emps;

}
