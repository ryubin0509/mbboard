<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 권한 업데이트</h2>
	<form action="/admin/memberUpdate" method="post">
	<table border="1">
	
	<input type= "hidden" name="memberPw" value="${member.memberPw}" readonly="readonly"> 
	
	<tr>
	<th>회원 아이디 </th>
	<td>	<input type= "text" name="memberId" value="${member.memberId}" readonly="readonly"> </td>
	</tr>
	
	
	<tr>
	<th>회원 권한 </th>
	<td> <input type= "text" name="memberRole" value="${member.memberRole}"> </td>
	</tr>
	
	
	</table>
	
	<button type="submit" >권한수정</button>
	</form>
</body>
</html>