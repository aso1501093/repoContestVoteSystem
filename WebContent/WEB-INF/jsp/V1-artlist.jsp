<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票受付中作品一覧</title>
</head>
<body class="back">
	<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

	<center>
		<h1><c:out value="${ contestDetail.name }" /></h1>
		<table>
			<tr>
				<th align="right">テーマ:</th>
				<td><c:out value="${ contestDetail.theme }" /></td>
			</tr>
			<tr>
				<th align="right">応募期間:</th>
				<td><c:out value="${entryDate}" /></td>
			</tr>
			<tr>
				<th align="right">投票期間:</th>
				<td><c:out value="${voteDate}" /></td>
			</tr>
			<tr>
				<th align="right">応募資格:</th>
				<td><c:out value="${ contestDetail.qualifications }" />
				</td>
			</tr>
			<tr>
				<th align="right">賞品:</th>
				<td><c:out value="${ contestDetail.prize }" />
				</td>
			</tr>
		</table>
		<br><br>

		<table border="1">
			<c:forEach var="list" items="${artList}" varStatus="status">
				<c:if test="${status.first}">
					<tr>
				</c:if>

						<td>
							<a href="/Contest/V2ArtDetail?art_id=<c:out value="${ list.art_id }"/>"><c:out value="${ list.art_title }"/>
							</a>
							<a href="/Contest/V2ArtDetail?art_id=<c:out value="${ list.art_id }"/>"><img src="${ list.base64Image }" width="300" height="210" />
							</a>
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
						<td></td><td></td><td></td>
					</tr>
				</c:if>
				<c:if test="${ status.count % 4 == 2 }">
						<td></td><td></td>
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

	<%--
<c:forEach var="arts" items="${artList}" varStatus="loop">
	<div class="img-left">
		<a href="/Contest/V2ArtDetail?art_id=<c:out value="${ arts.art_id }"/>"><figure> <img src="${arts.base64Image}" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p><c:out value="${arts.title}"/></p>
		</figcaption> </figure></a>
	</div>
</c:forEach>
--%>
</body>
</html>