<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="ct_page" value="난 페이지에서만 가능함" scope="page"/>
<c:set var="ct_request" value="난 리퀘스트에서 가능함" scope="request"/>
<c:set var="ct_session" value="난 세션에서 가능하지" scope="session"/>
<c:out value="${ct_page}"/><br>
${ct_page }
<br>
${ct_request}
</body>
</html>