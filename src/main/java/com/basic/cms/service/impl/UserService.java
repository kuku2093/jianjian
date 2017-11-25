package com.basic.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.cms.core.ResponseModel;
import com.basic.cms.mapper.TblUserMapper;
import com.basic.cms.model.TblUser;
import com.basic.cms.model.TblUserExample;
import com.basic.cms.model.TblUserExample.Criteria;
import com.basic.cms.service.IUserService;



@Service
public class UserService implements IUserService {

	@Autowired
	private TblUserMapper tblUserMapper;
	
	@Override
	public ResponseModel register(TblUser user) {
		// TODO Auto-generated method stub
		
        try {
        	tblUserMapper.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseModel.build(0, "插入失败");
		}
		
		return ResponseModel.build(1, "插入成功");
	}

	@Override
	public ResponseModel getMessage(Integer id) {
		// TODO Auto-generated method stub
		TblUser user = null;
		try {
			 user =  tblUserMapper.selectByPrimaryKey(id);
			 if (user == null) {
				 return ResponseModel.build(0, "查询失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseModel.build(0, "查询失败");
		}
		
		return ResponseModel.build(1, "查询成功",user);
	}

	@Override
	public ResponseModel list() {
		// TODO Auto-generated method stub
       TblUserExample example = new TblUserExample();
        Criteria criteria =   example.createCriteria();
		List<TblUser> userList =  tblUserMapper.selectByExample(example);
        
		return ResponseModel.build(1, "查询成功",userList);
	}

	
}
