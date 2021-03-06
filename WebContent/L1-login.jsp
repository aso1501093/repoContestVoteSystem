<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript">
function formData(){
	// フォームタグを生成
	var form = document.getElementById('form');
	form.submit();
}
</script>
</head>

<body class="login-content">
<div class="login-form">
<div class="container">
	<h1>コンテスト投票</h1>
	<h2><font color="red"><c:out value="${error}" /></font></h2>

	<form method="POST" action="T1Login" id="form">
			<!-- ユーザID -->
			<div class="form-group">
				<label class="col-sm-2 control-label" for="InputID">学生ID</label>
				<div class="col-sm-5">
					<input type="text"  class="form-control" name="id"
						id="InputID">
				</div>
			</div>
			<br>
			<br>
			<br>
			<!-- password -->
			<div class="form-group">
				<label class="col-sm-2 control-label" for="InputPassword">パスワード</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" name="pass"
						id="InputPassword">
				</div>
			</div>
			<br>
			<br>
			<br>

			<a class="login-button" onclick="formData();"><span data-hover="ログイン">Login</span></a>

			<br>
			<br>
			<br>
		</form>



	<p>まだ登録されてない方はこちら</p><br>
	<a onclick="javascript:location.href='L2-regist.jsp';" class="newuser">新規登録</a>
	<p><c:out value="${registrationMessage}" /></p>
	</div>
	</div>
</body>
</html>