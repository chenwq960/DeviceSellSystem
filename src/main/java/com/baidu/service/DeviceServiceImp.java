package com.baidu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.User;
import com.baidu.dto.device;
import com.baidu.mapper.deviceMapper;

@Service
public class DeviceServiceImp implements IDeviceService{
	private static int count = 000000;
	@Autowired
	private deviceMapper mapper;
	public List<device> seachDevice() {
		return mapper.seachDevice();
	}
	@Override
	public void create(device device, HttpSession session) {
		device.setCreateTime(new Date());
		User attribute = (User) session.getAttribute("currentUser");
		device.setCreateUser(attribute.getUserId());
		device.setUpdateTime(new Date());
		device.setUpdateUser(attribute.getUserId());
		
		SimpleDateFormat datefm = new SimpleDateFormat("yyyy-mm");
		String date = datefm.format(new Date());
		date+="-"+(count++);
		System.out.println("时间为"+date);
		device.setDeviceCode(date);
		device.setIsDelete((byte)0);
		System.out.println(count+++"count的数量为");
		mapper.insert(device);
	}
	@Override
	public void delete(Integer deviceId) {
		mapper.deleteByPrimaryKey(deviceId);
		
	}
	@SuppressWarnings("unused")
	@Override
	public void update(device device,HttpSession session) {
		device.setUpdateTime(new Date());
		User attribute = (User) session.getAttribute("currentUser");
		device.setUpdateUser(attribute.getUserId());
		int updateByPrimaryKey = mapper.updateByPrimaryKey(device);
	}


}
