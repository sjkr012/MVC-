<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> MVC 주소록 </h2>
	<hr/>

	<form action="search_view.s">
		검색 선택: &nbsp;  
		<select name="query">
			<option value="name">이름</option>
			<option value="telno">전화번호</option>
			<option value="address">주소</option>
			<option value="relation">관계</option>
		</select>
		
		<input type="text" name="search" size="30">
		<input type="submit" value="검색"> <br/>
		
	</form>
	<br/><br/>
	
	<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>전자우편</th><th>관계</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td> <a href="content_view.s?seqno=${dto.sSeqno}"> ${dto.sSeqno} </a> </td>
			<td> ${dto.sName} </td>
			<td> ${dto.sTelno} </td>
			<td> ${dto.sAddress} </td>
			<td> ${dto.sEmail} </td>
			<td> ${dto.sRelation} </td> 
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6"> <a href="write_view.s"> 주소록등록 </a> 
		
		</tr>
	
	</table>


</body>
</html>