package com.basic.cms.service;

import com.basic.cms.core.ResponseModel;
import com.basic.cms.model.TblUser;

public interface IUserService {

	ResponseModel register(TblUser user);
	ResponseModel getMessage(Integer id);
	ResponseModel list();
}
