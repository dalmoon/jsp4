<%@page import="java.util.Iterator"%>
<%@page import="com.test.jsp.common.ListExam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트 테스트</title>
</head>
<body>
	jstl's test : ${test}
	<br> session test : ${s_test}
	<br> application test : ${a_test}
	<%
		String[] strs = { "1", "2", "3" };
		request.setAttribute("strArray", strs);
		UserInfo[] userList = new UserInfo[3];
		for(int i =0; i <3 ; i++){
		UserInfo ui = new UserInfo();
		ui.setUserName("test" + (i+1));	
		ui.setUserNo(i+1);	
		ui.setUserAge(i+1);	
		userList[i] = ui;
		}
		
		request.setAttribute("userList", userList);
	%>
	<c:forEach var="str" items="${strArray}">
${str},
</c:forEach>
	<table border="1">
		<tr>
			<th>유저번호</th>
			<th>유저이름</th>
			<th>유저나이</th>
		</tr>
		<c:forEach var="ui" items="${userList}">
			<tr>
				<td>${ui.userNo}</td>
				<td>${ui.userName}</td>
				<td>${ui.userAge}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>