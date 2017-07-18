<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>コンテスト投票</h1>
	<h2><font color="red"><c:out value="${error}" /></font></h2>
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
	<p>まだ登録されてない方はこちら</p><br>
	<button onclick="javascript:location.href='L2-regist.jsp';">新規登録</button>
	<p><c:out value="${registrationMessage}" /></p>
</body>
</html>