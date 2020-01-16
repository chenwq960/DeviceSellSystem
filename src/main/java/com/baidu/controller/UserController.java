package com.baidu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.User;
import com.baidu.service.IUserService;
import com.baidu.util.BaiduUtil;
import com.baidu.util.BaiduUtil.IdCardFront;
import com.baidu.util.CommonUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	// 登陆的验证方法
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(String account, String password, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		ModelAndView mav = new ModelAndView();
		try {
			User user = userService.queryDetailByAccount(account);
			if (Objects.isNull(user)) {
				throw new RuntimeException("当前账号不存在");
			} else if (Objects.equals(user.getPassword(), CommonUtil.md5(password)) == false) {
				throw new RuntimeException("密码错误");
			}
			request.getSession().setAttribute("currentUser", user);
			response.sendRedirect(request.getContextPath() + "/views/layout/main.jsp");
			return null;
		} catch (Exception e) {
			mav.addObject("msg", e.getMessage());
			mav.setViewName("user/login");
		}
		return mav;
	}

//查看所有的方法
	@RequestMapping("/list")
	public ModelAndView list() {
		List<User> list = userService.showUser();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("user/list");
		return mav;
	}
//查看详细的方法
	@ResponseBody
	@RequestMapping("/detailed")
	public User detailed(String UserId) {
		System.out.println("喂喂喂喂"+UserId);
		User user = userService.showDetailed(UserId);
		return user;
	}
//增加的方法
	@RequestMapping("/create")
	public void create(User user, MultipartFile photo, HttpSession session,String dName) {
	//根据部门的名称查询部门的ID
		int selectUserDepartment = userService.selectUserDepartment(dName);
	//添加部门的id
		user.setDepartmentId(selectUserDepartment);
		String name = photo.getOriginalFilename();
		// 随机分配一个名字
		name = UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
		// 存放位置
		String filePath = session.getServletContext().getRealPath("");
		// 吧图片和位置关联起来
		File file = new File(filePath, name);
	//调用百度接口
		IdCardFront idCardFrontInfo = BaiduUtil.seachPhoto(filePath +"\\"+name);
		// 渲染到文件夹的下面
		try {
			photo.transferTo(file);
		//打乱密码
			String md5 = CommonUtil.md5(user.getPassword());
		//向业务层传值
			userService.create(user,idCardFrontInfo,md5,name,session);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
//删除的方法
	@ResponseBody
	@RequestMapping("/delete")
	public boolean delete(Integer userId) {
		try {
			userService.delete(userId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
