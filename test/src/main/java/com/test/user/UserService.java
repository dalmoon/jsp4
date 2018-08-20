package com.test.user;

public interface UserService {
	public int userInsert(UserVO vo);
	public UserVO userLogin(UserVO vo);
	public int idDuplChk(String id);
}
