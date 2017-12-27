package com.test.jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.test.jsp.dto.DepartInfo;

public interface DepartDAO {
	public ArrayList<DepartInfo> selectDepartList(String search, String searchStr) throws SQLException;
	public DepartInfo selectDepart(int diNo) throws SQLException;
	public int updateDepart(DepartInfo di) throws SQLException;
	public int insertDepart(DepartInfo di) throws SQLException;
	public int deleteDepart(DepartInfo di) throws SQLException;
}
