package com.baidu.po;

import java.util.Date;

public class UserPO {
    private Integer userId;

    private Integer roleId;

    private Integer departmentId;

    private String account;

    private String password;

    private String userName;

    private String realName;

    private Boolean sex;

    private Date birthday;

    private String nation;

    private String idCard;

    private String idCardFront;

    private String idCardBack;

    private String address;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Boolean isDelete;
    
    private RolePO rolePO;
    private DepartmentPO departmentPO;
    private UserPO createUserObj;
    private UserPO updateUserObj;

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
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront == null ? null : idCardFront.trim();
    }

    public String getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack == null ? null : idCardBack.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public RolePO getRolePO() {
        return rolePO;
    }

    public void setRolePO(RolePO rolePO) {
        this.rolePO = rolePO;
    }

    public DepartmentPO getDepartmentPO() {
        return departmentPO;
    }

    public void setDepartmentPO(DepartmentPO departmentPO) {
        this.departmentPO = departmentPO;
    }

    public UserPO getCreateUserObj() {
        return createUserObj;
    }

    public void setCreateUserObj(UserPO createUserObj) {
        this.createUserObj = createUserObj;
    }

    public UserPO getUpdateUserObj() {
        return updateUserObj;
    }

    public void setUpdateUserObj(UserPO updateUserObj) {
        this.updateUserObj = updateUserObj;
    }
    
    
}