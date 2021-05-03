package com.summitthai.tdd_homework;

import java.util.List;

import com.summitthai.tdd_homework.model.HrstDepartment;

public interface HrstDepartmentServiceable {

	public HrstDepartment getByPk(Long deptCode);

	public List<HrstDepartment> searchDeptCode(String deptCodeAction);

	public List<Object[]> findForManageBox(String deptCode);

}
