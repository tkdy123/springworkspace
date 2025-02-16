package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
public class DeptTest {
	@Autowired // 필드 주입 => 단순 테스트용
	private DeptMapper deptMapper;
	
	// 전체조회
	//@Test 
	  void contextLoads() { 
	  List<DeptVO> list = deptMapper.selectDeptList();
	  for(DeptVO dept : list) { 
		  System.out.println(dept); 
		  }
	  assertTrue(!list.isEmpty()); 
	  }
	
	// 단건조회
	//@Test
	void infoTest() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(110);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		
		System.out.println(findVO);
		
		assertEquals("Accounting", findVO.getDepartmentName());
		// 첫번쨰 매개변수 : 기대하는 값
		// 두번째 매개변수 : 실제 값
		// => 두 개가 같으면 테스트 성공, 다르면 실패
	}
	
	// 등록
	//@Test
	void insertTest() throws ParseException {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentName("ITS");
		deptVO.setManagerId(206);
		deptVO.setLocationId(1800);

		
		int result = deptMapper.insertDeptInfo(deptVO);
		
		assertEquals(1, result);
	}
	
	// 수정
	//@Test
	void updateTest() {
		// 1) 단건 조회
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(200);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		// 2)수정할 데이터
		findVO.setDepartmentName("IT_SERVICE");
		findVO.setLocationId(1700);
		// 3) 수정
        int result = deptMapper.updateDeptInfo(findVO);
	    
	    assertEquals(1, result);
	}
	
	// 삭제
    @Test
	void deleteTest() {
		int result = deptMapper.deleteDeptInfo(200);
		assertEquals(1, result);
	}
	
	
}
