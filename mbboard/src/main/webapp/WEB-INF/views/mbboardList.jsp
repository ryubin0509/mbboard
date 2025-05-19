<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script type="text/javascript">
$(function() {
	$('#submitbutton').click(function(){
		 $('#mbboardList').submit();
	})
});
</script>
</head>
<body>

<form id ="mbboardList" method="get" action="mbboardList" >

<a href="/mbinsertList">작성하기</a>
<table border="1">
	<tr>		
		<th> 번호	 </th>
		<th> 제목 </th>
	</tr>
	
	<c:if test="${empty list}">
    <tr><td colspan="4">데이터가 없습니다.</td></tr>
	</c:if>
	
	<c:forEach var="board" items="${list}">
	<tr>
		<td> 
		<a href="/mbListOne?boardNo=${board.boardNo}">${board.boardNo}</a>
		</td>
		<td>${board.boardTitle}</td>
	</tr>
	</c:forEach>

	
</table>

<input type="text" id="searchWord" name="searchWord" value="${page.searchWord}">
<button type="button" id ="submitbutton">검색하기</button>
</form>

<a href="/mbboardList?currentPage=1">처음</a>
	<c:if test="${page.currentPage>1}">
		<a href="/mbboardList?currentPage=${page.currentPage-1}&searchWord=${page.searchWord}">이전</a>
	</c:if>

	<c:if test="${page.currentPage< page.lastPage}">
		<a href="/mbboardList?currentPage=${page.currentPage+1}&searchWord=${page.searchWord}">다음</a>
	 </c:if>
	 	<a href="/mbboardList?currentPage=${page.lastPage}">마지막</a>
</body>
</html>