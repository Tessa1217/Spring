package com.company.app.emp.service;

import java.util.List;

public interface EmpService {
	
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpSearchVO vo);
	public List<EmpVO> getEmpByDept(String[] list);
	public int insertEmp(EmpVO vo);
	public int updateEmp(EmpVO vo);
	public int deleteEmp(EmpVO vo);
	public List<EmpVO> getEmpDept(EmpVO vo);

}
