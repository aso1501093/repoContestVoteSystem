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
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<br>

	<center>
		<h1><c:out value="${contestName.name}"/></h1>

		<table border="1">
			<c:forEach var="list" items="${artList}" varStatus="status">
				<c:if test="${ status.first }">
					<tr>
				</c:if>

						<td>
							<p align="center"><a href="/Contest/V2ArtDetail?art_id=<c:out value="${ list.art_id }"/>">${ list.title }</a></p>
							<p align="center">
								<a href="/Contest/V2ArtDetail?art_id=<c:out value="${ list.art_id }"/>">
									<img border="0" width="100" height="100" src="<c:out value="${ list.base64Image }"/>"/>
								</a>
							</p>
						</td>

				<c:if test="${ status.count % 4 == 0 && !status.last }">
					</tr>
					<tr>
				</c:if>

			<c:if test="${ status.last }">
				<c:if test="${ status.count % 4 == 0 }">
					</tr>
				</c:if>
				<c:if test="${ status.count % 4 == 1 }">
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:if>
				<c:if test="${ status.count % 4 == 2 }">
						<td></td>
						<td></td>
					</tr>
				</c:if>
				<c:if test="${ status.count % 4 == 3 }">
						<td></td>
					</tr>
				</c:if>
			</c:if>

			</c:forEach>
		</table>
	</center>
</body>
</html>