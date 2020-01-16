package com.baidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.po.DevicePO;

public interface IDeviceService {
	List<DevicePO> seachDevice();

	void create(DevicePO DevicePO,HttpSession session);

	void delete(Integer deviceId);

	void update(DevicePO DevicePO, HttpSession session );
}	
