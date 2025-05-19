<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>rechangeMemberPw</h1>
	<form action="rechangeMemberPw" method="post">
		<div>
			memberId <input type="text" name="memberId">
		</div>
		<div>
			메일로 받은 PW <input type="password" name="memberPw">
		</div>
		<div>
			변경할 PW <input type="password" name="rememberPw">
		</div>
		
		<button type="submit">패스워드 변경</button>

	</form>
</body>
</html>