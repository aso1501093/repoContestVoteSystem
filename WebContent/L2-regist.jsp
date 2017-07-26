<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
<link rel="stylesheet"  href="css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

<br><br>
<center>
	<p>登録用の学籍番号とパスワードを入力してください</p>
	<form method="POST" action="L1Registration">
	<br><br>
		<table>
			<tr>
				<td class="l2td">学籍番号</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td class="l2td">パスワード</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table><br><br>
		<a class="modoru-button" href="T1Login"><span data-hover="戻る">Back</span></a>
		<a class="touroku-button" href="T1Login"><span data-hover="登録">Entry</span></a>

		<%--
		<button type="submit" name="btn" value="back" class="modoru">戻る</button>
		<button type="submit" name="btn" value="registration" class="modoru">登録</button>
		 --%>
	</form>
	</center>
</body>
</html>