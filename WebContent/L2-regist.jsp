<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
<link rel="stylesheet"  href="css/main.css">
<script type="text/javascript">
function formData(params){
	// フォームタグを生成
	var form = document.getElementById('form');
	var btn=document.getElementById("btn");
	btn.value=params;

	// 生成したフォームをSUBMIT
	form.submit();
}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

<br><br>
<center>
	<p>登録用の学籍番号とパスワードを入力してください</p>
	<form method="POST" action="L1Registration" id="form">
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
		<a class="modoru-button" onclick="formData('');"><span data-hover="戻る">Back</span></a>
		<a class="touroku-button" onclick="formData('registration');"><span data-hover="登録">Entry</span></a>
		<input type="hidden" name="btn" id="btn">
		 
	</form>
	</center>
</body>
</html>