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
</head>

<body class="login-content">
<div class="login-form">
<div class="container">
	<h1>コンテスト投票</h1>
	<h2><font color="red"><c:out value="${error}" /></font></h2>

	<form method="POST" action="T1Login">
			<!-- ユーザID -->
			<div class="form-group">
				<label class="col-sm-2 control-label" for="InputID">学生ID</label>
				<div class="col-sm-5">
					<input type="text" name="memberId" class="form-control"
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
					<input type="password" name="password" class="form-control"
						id="InputPassword">
				</div>
			</div>
			<br>
			<br>
			<br>
			<!-- 送信ボタン -->
			<a class="login-button" href="T1Login"><span data-hover="ログイン">Login</span></a>
			<br>
			<br>
			<br>
		</form>



	<%--
	<form method="POST" action="T1Login">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table>
		<button type="submit">ログイン</button>
	</form>
	 --%>

	<p>まだ登録されてない方はこちら</p><br>
	<a href="#" class="newuser">新規登録</a>
	<%--
	<button onclick="javascript:location.href='L2-regist.jsp';">新規登録</button>
	 --%>
	<p><c:out value="${registrationMessage}" /></p>
	</div>
	</div>
</body>
</html>