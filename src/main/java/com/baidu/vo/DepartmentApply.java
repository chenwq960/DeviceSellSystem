package com.baidu.vo;

public class DepartmentApply {
    private String department;
    private Integer userNum;
    public DepartmentApply(String department, Integer userNum) {
        super();
        this.department = department;
        this.userNum = userNum;
    }
    public DepartmentApply() {
        super();
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Integer getUserNum() {
        return userNum;
    }
    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }
    @Override
    public String toString() {
        return "DepartmentApply [department=" + department + ", userNum=" + userNum + "]";
    }
   
    
    
    
    
}
