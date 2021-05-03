package com.summitthai.tdd_homework;

import java.util.ArrayList;
import java.util.List;

import com.summitthai.tdd_homework.model.HrstDepartment;

public class HrstDepartmentService implements HrstDepartmentServiceable {

	@Override
	public HrstDepartment getByPk(Long deptCode) {
		return mockHrstDepartment();
	}

	@Override
	public List<HrstDepartment> searchDeptCode(String deptCodeAction) {
		List<HrstDepartment> hrstDepartmentList = new ArrayList<>();
		HrstDepartment hrstDepartment = mockHrstDepartment();
		hrstDepartmentList.add(hrstDepartment);
		return hrstDepartmentList;
	}

	@Override
	public List<Object[]> findForManageBox(String deptCode) {
		return null;
	}
	
	private HrstDepartment mockHrstDepartment() {
		HrstDepartment hrstDepartment = new HrstDepartment();
		hrstDepartment.setDeptCode("123");
		hrstDepartment.setDeptCodeAction("SCC");
		hrstDepartment.setDeptName("Summit Computer");
		return hrstDepartment;
	}
}
