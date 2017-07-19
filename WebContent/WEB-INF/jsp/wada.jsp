<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
		<table border="1" style="border-collapse: collapse">
			<tr>
				<td>ID</td>
				<td>名前</td>
				<td>画像</td>
			</tr>
			<tr>
				<td><c:out value="1" /></td>
				<td><c:out value="タイトル" /></td>
				<td><img style="width: 100px; height: 100px" src="wadaTest?id=1"></td>
			</tr>
				<tr>
				<td><c:out value="1" /></td>
				<td><c:out value="タイトル" /></td>
				<td><img style="width: 100px; height: 100px" src="data:image/jpg;base64,${test}"></td>
			</tr>
			
		</table>
	</body>
</body>
</html>