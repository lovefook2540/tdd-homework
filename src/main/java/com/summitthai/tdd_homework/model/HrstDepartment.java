package com.summitthai.tdd_homework.model;

public class HrstDepartment {
	
	private String deptCodeAction;
	private String deptDeptCode;
	private String deptDeptName;
	
	public void setDeptCodeAction(String param) {
        deptCodeAction = param;
    }

    public void setDeptCode(String param) {
    	deptDeptCode = param;
    }

    public void setDeptName(String param) {
    	deptDeptName = param;
    }
	
    public String getDeptCodeAction() {
        return deptCodeAction;
    }

    public String getDeptCode() {
        return deptDeptCode;
    }

    public String getDeptName() {
        return deptDeptName;
    }
}
