<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 입력화면</title>
</head>
<body>
	<h1> 게시판 입력 </h1>
	<hr/>
	<form action = "write.com" method="post">
		<table border="0">
			
				<tr>
					<td>이름: </td>
					<td><input type="text" name = "name" size="50"><br/></td>
				</tr>
				<tr>
					<td>제목: </td>
					<td><input type="text" name = "telno" size="50"><br/></td>
				</tr>
				<tr>
					<td colspan="2"><input type = "submit" value="입력"> &nbsp; <a href="list.com"> 돌아가기 </a> </td>
				</tr>
			
		</table>
	</form>
</body>
</html>