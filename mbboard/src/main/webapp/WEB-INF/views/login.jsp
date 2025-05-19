<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginMember == null}">
		<!-- 로그인이 안되어 있다면 -->
		<form method="post" action="/login">
			<div>
				<div>memberId:</div>
				<div>
					<input type="text" name="memberId" value="${cookie.saveId.value}">
					<input type="checkbox" value="yes" name="saveIdCk"> 아이디 저장
				</div>
					
				<div>memberPw:</div>
				<div><input type="password" name="memberPw"></div>
				<div><button type="submit">로그인</button></div>
			</div>
		</form>
		<div><a href="/loginForm">회원가입</a></div>
		<div><a href="/findMemberPw">비밀번호 찾기</a></div>
	</c:if>
	
	<c:if test="${loginMember != null}">
		<!-- 로그인 되어 있다면 -->
		<div>
			${loginMember.memberId}님 <a href="/member/mebmerHome">memberHome</a>으로 이동
		</div>
		<div><a href="/logout">로그아웃</a></div>
	</c:if>
</body>
</html>
