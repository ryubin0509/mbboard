<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
  <h2>회원가입</h2>

  <form id="registerForm" method="post">
    <label>아이디:</label>
    <input type="text" name="memberId" id="memberId" required>
    <button type="button" id="checkIdBtn">중복 확인</button>
    <span id="idCheckResult"></span><br><br>

    <label>비밀번호:</label>
    <input type="password" name="memberPw" id="memberPw" required><br><br>

    <label>비밀번호 확인:</label>
    <input type="password" id="memberPwConfirm" required>
    <span id="pwMatchResult"></span><br><br>

    <input type="hidden" name="memberRole" value="member">

    <button type="submit">가입하기</button>
  </form>
  
  <script type="text/javascript">
  let idChecked = false;
  
  $(function(){
	   $('#checkIdBtn').click(function(){
		   const memberId = $('#memberId').val().trim();
		   if(memberId === ""){
			   $('#idCheckResult').text('아이디를 입력해주세요');
		   }
		   
		   $.ajax({
			  url: "/checkId" , // 서버 요청주소
			  method: "GET" ,
			  data: {memberId: memberId},
			  success: function(res) {
				  if(res === true || res === 'true'){
					  $('#idCheckResult').text('사용가능한 아이디입니다.');
				  } else{
					  $('#idCheckResult').text('이미 사용중인 아이디입니다.');
				  }
			  },
			  error: function(err){
				  alert("요청실패");
				  console.log(err);
			  }
		   })
		 })
	   
		   $.ajax({
			   url: "/registerForm" , //
			   method: "POST" ,
			   data: {}
			   
			   
		   })
		 
	   $('#memberPw').blur(function(){
		   const  memberPw = $('#memberPw').val().trim();
		   const  memberPw1 = $('#memberPwConfirm').val().trim();
		   
		   if(memberPw === memberPw1){
			   $('#pwMatchResult').text('비밀번호가 일치합니다.');
		   } else {
			   $('#pwMatchResult').text('비밀번호가 다릅니다.');
		   }
	   });
	   
	   $('#memberPwConfirm').blur(function(){
		   const  memberPw = $('#memberPw').val().trim();
		   const  memberPw1 = $('#memberPwConfirm').val().trim();
		   
		   if(memberPw === memberPw1){
			   $('#pwMatchResult').text('비밀번호가 일치합니다.');
		   } else {
			   $('#pwMatchResult').text('비밀번호가 다릅니다.');
		   }
	   });
	   
  })
  
  
  </script>
</body>
</html>
