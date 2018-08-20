package com.test.mapper;

import org.springframework.stereotype.Repository;

import com.test.user.UserVO;

@Repository(value="userMap")
public interface UserMap {
	public int uinsert(UserVO vo);
	public UserVO ulogin(UserVO vo);
	public int joinDAO_idDuplChk(String id);
}
