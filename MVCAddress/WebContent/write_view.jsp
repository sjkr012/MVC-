<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 입력</title>
</head>
<body>
	<h1> 주소록 입력 </h1>
	<hr/>
	<form action = "write.s" method="post">
		<table border="0">
			
				<tr>
					<td>이름: </td>
					<td><input type="text" name = "name" size="50"><br/></td>
				</tr>
				<tr>
					<td>전화번호: </td>
					<td><input type="text" name = "telno" size="50"><br/></td>
				</tr>
				<tr>
					<td>주소: </td>
					<td><input type="text" name = "address" size="50"> <br/> </td>
				</tr>
				<tr>
					<td>전자우편: </td>
					<td><input type="text" name = "email" size="50"> <br/> </td>
				</tr>
				<tr>
					<td>관계: </td>
					<td><input type="text" name = "relation" size="50"> <br/> </td>
				</tr>
				<tr>
					<td colspan="2"><input type = "submit" value="입력"><br/> </td>
					<td colspan="2"><a href="list.s"> 돌아가기 </a> </td>
				
				</tr>
			
		</table>
	</form>

</body>
</html>