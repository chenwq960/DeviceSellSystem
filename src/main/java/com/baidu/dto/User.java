package com.baidu.dto;

import java.util.Date;

public class User {

	private Integer userId;
	private Integer roleId;
	private Integer departmentId;
	private String account; // ------
	private String password;
	private String userName;// ---
	private String realName;
	private Integer sex;
	private Date birthday;
	private String nation;
	private String idCard;
	private String idCardFront; /// ----
	private String idCardBack; ////////
	private String address;
	private Date createTime;
	private Integer createUser;
	private Date updateTime;
	private Integer updateUser;
	private int isDelete;

	private Role role;
	private Department department;
	private User createUserObj;
	private User updateUserObj;

	public User() {
	}

	public User(Integer userId, Integer roleId, Integer departmentId, String account, String password, String userName,
			String realName, Integer sex, Date birthday, String nation, String idCard, String idCardFront,
			String idCardBack, String address, Date createTime, Integer createUser, Date updateTime, Integer updateUser,
			int isDelete) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.departmentId = departmentId;
		this.account = account;
		this.password = password;
		this.userName = userName;
		this.realName = realName;
		this.sex = sex;
		this.birthday = birthday;
		this.nation = nation;
		this.idCard = idCard;
		this.idCardFront = idCardFront;
		this.idCardBack = idCardBack;
		this.address = address;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.isDelete = isDelete;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the idCardFront
	 */
	public String getIdCardFront() {
		return idCardFront;
	}

	/**
	 * @param idCardFront the idCardFront to set
	 */
	public void setIdCardFront(String idCardFront) {
		this.idCardFront = idCardFront;
	}

	/**
	 * @return the idCardBack
	 */
	public String getIdCardBack() {
		return idCardBack;
	}

	/**
	 * @param idCardBack the idCardBack to set
	 */
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the createUser
	 */
	public Integer getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the updateUser
	 */
	public Integer getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the isDelete
	 */
	public int getIsDelete() {
		return isDelete;
	}

	/**
	 * @param i the isDelete to set
	 */
	public void setIsDelete(int i) {
		this.isDelete = i;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the createUserObj
	 */
	public User getCreateUserObj() {
		return createUserObj;
	}

	/**
	 * @param createUserObj the createUserObj to set
	 */
	public void setCreateUserObj(User createUserObj) {
		this.createUserObj = createUserObj;
	}

	/**
	 * @return the updateUserObj
	 */
	public User getUpdateUserObj() {
		return updateUserObj;
	}

	/**
	 * @param updateUserObj the updateUserObj to set
	 */
	public void setUpdateUserObj(User updateUserObj) {
		this.updateUserObj = updateUserObj;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", roleId=" + roleId + ", departmentId=" + departmentId + ", account="
				+ account + ", password=" + password + ", userName=" + userName + ", realName=" + realName + ", sex="
				+ sex + ", birthday=" + birthday + ", nation=" + nation + ", idCard=" + idCard + ", idCardFront="
				+ idCardFront + ", idCardBack=" + idCardBack + ", address=" + address + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ ", isDelete=" + isDelete + ", role=" + role + ", department=" + department + ", createUserObj="
				+ createUserObj + ", updateUserObj=" + updateUserObj + "]";
	}

}