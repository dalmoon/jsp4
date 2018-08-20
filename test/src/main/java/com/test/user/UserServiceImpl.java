package com.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.mapper.UserMap;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMap userMap;
	
	public int userInsert(UserVO vo) {
		return userMap.uinsert(vo);
	}
	
	public UserVO userLogin(UserVO vo) {
		return userMap.ulogin(vo);
	}
	
	public int idDuplChk(String id) {
		return userMap.joinDAO_idDuplChk(id);
	}
}
