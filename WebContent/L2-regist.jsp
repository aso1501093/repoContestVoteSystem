
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
	<p>登録用の学籍番号とパスワードを入力してください</p>
	<form method="POST" action="L1Registration">
		<table>
			<tr>
				<td>学籍番号</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table><br><br>
		<button type="submit" name="btn" value="back">戻る</button>
		<button type="submit" name="btn" value="registration">登録</button>
	</form>
</body>
</html>