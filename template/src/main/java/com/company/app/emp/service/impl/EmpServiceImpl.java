package com.company.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.service.EmpSearchVO;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;

@Service // @Component를 상속 받음, @Service로 빈 등록 가능
public class EmpServiceImpl implements EmpService {
	
	@Autowired EmpMapper mapper;

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return mapper.getEmp(vo);
	}

	@Override
	public List<EmpVO> getEmpList(EmpSearchVO vo) {
		return mapper.getEmpList(vo);
	}

	@Override
	public List<EmpVO> getEmpByDept(String[] list) {
		return mapper.getEmpByDept(list);
	}

	@Override
	public int insertEmp(EmpVO vo) {
		return mapper.insertEmp(vo);
	}

	@Override
	public int updateEmp(EmpVO vo) {
		return mapper.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		return mapper.deleteEmp(vo);
	}


}
