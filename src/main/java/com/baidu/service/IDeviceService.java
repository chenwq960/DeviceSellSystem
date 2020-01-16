package com.baidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.dto.device;

public interface IDeviceService {
	List<device> seachDevice();

	void create(device device,HttpSession session);

	void delete(Integer deviceId);

	void update(device device, HttpSession session );
}	
