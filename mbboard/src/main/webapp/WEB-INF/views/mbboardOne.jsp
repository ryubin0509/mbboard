<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">

<tr>	
	<th>게시글 번호</th>
	<td>${board.boardNo}</td>
</tr>

<tr>
	<th>제목</th>
	<td>${board.boardTitle}</td>
</tr>

<tr>
	<th>내용 </th>
	<td>${board.boardContent}</td>
</tr>

<tr>
	<th>사용자</th>
	<td>${board.boardUser}</td>
</tr>

</table>

<a href="/updatembListOne?boardNo=${board.boardNo}">수정하기</a>
<a href="/deletembListOne?boardNo=${board.boardNo}">삭제하기</a>

</body>
</html>