package com.company.mvc.emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	public Map<String, Object> getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpVO vo);
	public List<EmpVO> getEmpByDept(String[] list);
}
