<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/mbinsertList" method="post">

<table border="1" >
	<tr>	
		 <th>제목</th>
		 <td><input type="text" name="boardTitle" placeholder="제목을 입력하세요" required="required"> </td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td><input type="text" name="boardContent" placeholder="내용을 입력하세요" required="required" ></td>
	</tr>
	
	<tr>
		<th>글쓴이</th>
		<td><input type="text" name="boardUser" placeholder="글쓴이를 입력하세요" required="required"></td>
	</tr>
	
</table>

<button type="submit">작성하기</button>

</form>


</body>
</html>