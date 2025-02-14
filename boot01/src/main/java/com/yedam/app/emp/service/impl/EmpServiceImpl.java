package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service // @Transcational 사용 가능
public class EmpServiceImpl implements EmpService{
	// 구현클래스 @Service
	// DB가 필요한 경우 Mapper는 여러개가 가능
	private EmpMapper empMapper;
	
	@Autowired
	EmpServiceImpl(EmpMapper empMapper){
		this.empMapper = empMapper;
	}
	
	// 전체조회
	@Override
	public List<EmpVO> findAllEmp() {
		return empMapper.selectEmpList();
	}
	
	// 단건조회
	@Override
	public EmpVO findEmpInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}
	
	// 등록
	@Override
	public int createEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}
	
	// 수정
	@Override
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		
		/*
		 {
		   "result" : true,
		   "target" : {
		                 employeeId : 100 ,
		                 lastName : "King",
		                 ...
		               }
		 };
		  */
		
		return map;
	}
	
	// 삭제
	@Override
	public Map<String, Object> removeEmpInfo(int employeeId) {
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(employeeId);
		
		if (result == 1) {
			map.put("employeeId", employeeId);
		}
		// {}
		// { "employeeId" : 104}
		return map;
	}
	
	
	
}
