package com.basic.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.cms.core.ResponseModel;
import com.basic.cms.model.TblUser;
import com.basic.cms.service.IUserService;



@RestController
@RequestMapping("/server")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/save")
	public ResponseModel check(TblUser user) {
		if(user.getUsername() == null) {
			return ResponseModel.build(0, "用户信息为空");
		}
		return service.register(user);
	}
	
	@RequestMapping("/get")
	public ResponseModel getMessage(Integer id) {
		if (id == null) {
			return ResponseModel.build(0, "查询id不可为空");
		}
		return service.getMessage(id);
	}
	
	@RequestMapping("/list")
	public ResponseModel list() {
		return service.list();
	}
	
	
	
	
	
	
	
	
}
