package com.company.mvc.emp;

import java.util.List;

import lombok.Data;

@Data
public class EmpSearchVO {
	
	private String employeeId;
	private List<String> depts;
	private String jobId;
	private String sdt;
	private String edt;

}
