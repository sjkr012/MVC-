<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 수정 화면</title>
</head>
<body>
	<h2> 주소록 수정 </h2>
	<hr/>
	<form action = "modify.s" method="post">
		<table border="0">
				<tr>
					<td>번호</td>
					<td><input type="text" name = "seqno" value = "${content_view.sSeqno}" size = "50" readonly="readonly"> </td>
				</tr>	
				<tr>
					<td>이름</td>
					<td><input type="text" name = "name" value = "${content_view.sName}" size="50"><br/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name = "telno" value = "${content_view.sTelno}"  size="50"><br/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name = "address" value = "${content_view.sAddress}"  size="50"><br/></td>
				</tr>
				<tr>
					<td>전자우편</td>
					<td><input type="text" name = "email" value = "${content_view.sEmail}"  size="50"><br/></td>
				</tr>
				<tr>
					<td>관계</td>
					<td><input type="text" name = "relation" value = "${content_view.sRelation}"  size="50"><br/></td>
				</tr>

				<tr>
					<td colspan="2"> <input type = "submit" value="수정"> &nbsp;&nbsp;&nbsp; 
							<a href="delete.s?seqno=${content_view.sSeqno}"> 삭제 </a><br/></td>
				</tr>
		</table>

	</form>



</body>
</html>