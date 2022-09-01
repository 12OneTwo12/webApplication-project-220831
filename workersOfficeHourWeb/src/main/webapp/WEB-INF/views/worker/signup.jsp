<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanks Join us</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/signup.css">
</head>
<body>
<div class="container" id="container">
	<div class="form-container sign-in-container">
		<form action="worker_signUp">
			<h1>Sign Up</h1>
			<div class="social-container">
			</div>
			<input type="text" name="worker_id"placeholder="Id" />
			<input type="password" name="worker_password"placeholder="Password" />
			<input type="text" name="pwck"placeholder="Password_check" />
			<input type="text" name="name"placeholder="Name"/>
			<input type="text" name="career"placeholder="carrer"/>
			<div class="gender">
			<label><input type="checkbox" name="gender" value="남"  onclick="NoMultiChk(this)">Man</label>
			<label><input type="checkbox" name="gender" value="여"  sonclick="NoMultiChk(this)">Woman</label>
			</div>
			<!--아이디, 비번, 이름, 성별, 연차,   -->
			<input type="submit" class="sign_up" value="Sign UP">
		</form>
	</div>
</body>
</html>

<script>
function NoMultiChk(chk){
	  var obj = document.getElementsByName("gender");
	   for(var i=0; i<obj.length; i++){
	     if(obj[i] != chk){
	       obj[i].checked = false;
	     }
	   }
	}
</script>