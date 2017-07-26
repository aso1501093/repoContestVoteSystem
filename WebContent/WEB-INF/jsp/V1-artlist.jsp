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


<%--

<body class="back">
	<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

	<center>
	<h1>浴衣写真コンテスト</h1>
	<table>
		<tr>
			<th>テーマ</th>
			<td>人物の浴衣姿を含む写真</td>
		</tr>
		<tr>
			<th>応募期間</th>
			<td>2017年6月20日～2017年9月20日</td>
		</tr>
		<tr>
			<th>投票期間</th>
			<td>2017年9月21日～2017年9月30日</td>
		</tr>
		<tr>
			<th>応募資格</th>
			<td>・日本国内にお住まいの方(日本国内で賞品の受け取りが可能な方)
			<br>・応募点数に制限はございません
			<br>・過去に受賞した作品の応募はご遠慮ください
			</td>
		</tr>
		<tr>
			<th>賞品</th>
			<td>グランプリ:30,000円(1名)
			<br>優秀賞:10,000円(3名)
			</td>
		</tr>
	</table>
	</center>
	<br><br>


	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>


	<br>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>


	<br>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>

	<div class="img-left">
		<figure> <img src="img/IMG_1503.JPG" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p>caption text here ...</p>
		</figcaption> </figure>
	</div>


	<br>


</body>
--%>
</html>