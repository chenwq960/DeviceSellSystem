package com.baidu.form;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UserParam {
    private Integer userId;
    private Integer roleId;
    private Integer departmentId;
    private String account;
    private String password;
    private String userName;

    private MultipartFile idCardFile;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MultipartFile getIdCardFile() {
        return idCardFile;
    }

    public void setIdCardFile(MultipartFile idCardFile) {
        this.idCardFile = idCardFile;
    }

    public void transferIdCardFile(File distFile) throws IllegalStateException, IOException {
        this.idCardFile.transferTo(distFile);
    }

}
