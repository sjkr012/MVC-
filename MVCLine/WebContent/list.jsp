<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC 패턴 One Line 게시판</title>
</head>
<body>
	<h3> One Line 게시판 </h3>
	<hr/>
	<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>제목</th><th>날짜</th><th>삭제</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td> ${dto.bId}  </td>
			<td> ${dto.bName} </td>
			<td> ${dto.bTitle} </td>
			<td> ${dto.bDate } </td>
			<td> <a href="delete.com?bId=${dto.bId}"> X </a> </td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6"> <a href="write_view.com"> 글작성 </a> 
		</tr>

	</table>

</body>
</html>