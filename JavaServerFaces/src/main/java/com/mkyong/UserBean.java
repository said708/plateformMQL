package com.mkyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mkyong.user.bo.UserBo;

@Component
@Scope("session")
public class UserBean {
	
	@Autowired
	UserBo userBo;
	
	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public String printMsgFromSpring() {
		return userBo.getMessage();
	}	
	
	
}