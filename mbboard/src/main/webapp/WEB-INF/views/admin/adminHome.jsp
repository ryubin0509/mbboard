<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${loginMember.memberId} 관리자</h1>
	<div><a href="/logout">로그아웃</a></div>
	<h2>멤버리스트</h2>
	<c:forEach var="member" items="${member}">
	 <table border="1">
	 <tr>		
	 	 <th>회원 아이디</th>
	 	 <th>회원 비밀번호</th>
	 	 <th>회원 권한및 역할</th>
	 	 <th>역할 수정하기 </th>
	 </tr>
	 
	 <tr>
	 	<td>${member.memberId}</td>
	 	<td>${member.memberPw}</td>
	 	<td>${member.memberRole}</td>
	 	<td><a href="/admin/memberUpdate?memberId=${member.memberId}">회원권환 수정</a></td>
	 	
	 </tr>
	 
	 
	 	
	 	
	 </tr>
	  </table>
	 </c:forEach>
	 
	
	 
	 <c:if test="${Page.currentPage >1}"><a href="/admin/adminHome?currentPage=${Page.currentPage-1}">이전</a></c:if>
	 
	<c:if test="${Page.currentPage <Page.lastPage}"><a href="/admin/adminHome?currentPage=${Page.currentPage+1}">다음</a></c:if>
</body>
</html>
