package com.baidu.vo;

import java.util.Date;

public class UserCreateTime {
    private String username;
    private Date createtime;
    public UserCreateTime() {
    }
    public UserCreateTime(String username, Date createtime) {
        super();
        this.username = username;
        this.createtime = createtime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Override
    public String toString() {
        return "UserCreate [username=" + username + ", createtime=" + createtime + "]";
    }
    
    
    
}
