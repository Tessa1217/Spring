package com.company.app.emp.mapper;

import java.util.List;

import com.company.app.emp.service.DepartmentVO;
import com.company.app.emp.service.EmpSearchVO;
import com.company.app.emp.service.EmpVO;

public interface EmpMapper {	
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpSearchVO vo);
	public List<EmpVO> getEmpByDept(String[] list);
	public int insertEmp(EmpVO vo);
	public int updateEmp(EmpVO vo);
	public int deleteEmp(EmpVO vo);
	public List<EmpVO> getEmpDept(EmpVO vo);
	public List<DepartmentVO> getDeptEmp(DepartmentVO vo);
}
