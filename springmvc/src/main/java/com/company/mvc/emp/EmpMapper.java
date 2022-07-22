package com.company.mvc.emp;

import java.util.List;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<DepartmentVO> getDepartmentList(); 
	public List<EmpVO> getEmpList(EmpSearchVO vo);
	public List<EmpVO> getEmpByDept(String[] list);
	public int getEmpInsert(EmpVO vo);
	public int getEmpUpdate(EmpVO vo);
	public int empDelete(EmpVO vo);
}
