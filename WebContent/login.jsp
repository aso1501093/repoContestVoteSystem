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

<body>
<div class="container">
	<h2>id、パスワードを入力してください</h2>
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
	</form>
	</div>
</body>
</html>