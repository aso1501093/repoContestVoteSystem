<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品一覧</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<br>
	<br>

	<table border="1">
		<tr>
			<td>開催中コンテスト</td>
		</tr>

		<c:forEach var="i" items="${list}" varStatus="status">
			<c:forEach var="i" items="${list}">
				<tr>
					<c:forEach var="i" items="${list} begin="0" end="3" step="1">
						<th><a href="/contestvote/V2ArtList?art_id=<c:out value="${ i.art_id }"/>">${ i.art_name }</a></th>
						<td><a href="/contestvote/V2ArtList?art_id=<c:out value="${ i.art_id }"/>"><img src="${ i.art_img_name }"></a></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</c:forEach>

	</table>
</body>
</html>