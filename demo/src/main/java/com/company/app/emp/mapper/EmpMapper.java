package com.company.app.emp.mapper;

import java.util.List;

public interface EmpMapper {
	
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpVO vo);
	public int empInsert(EmpVO vo);
	public List<JobVO> getJobs(JobVO vo);
	public List<DepartmentVO> getDepartments(DepartmentVO vo);
	public int empUpdate(EmpVO vo);

}
