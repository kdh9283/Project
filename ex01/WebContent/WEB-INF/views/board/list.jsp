<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">LIST ALL PAGE</h3>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-bordered">
			<tr>
				<td style="width:10px">BNO</td>
				<td>TITLE</td>
				<td>WRITER</td>
				<td>REGDATE</td>
				<td style="width:40px">VIEWCNT</td>
			</tr>
			<c:forEach items="${list}" var="b">
				<tr>
					<td>${b.bno}</td>
					<td><a href="/board/read?bno=${b.bno}">${b.title}</a></td>
					<td>${b.writer}</td>
					<td>${b.regdate}</td>
					<td>${b.viewcnt}</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
		${pageHtml }
<%@include file="../include/footer.jsp" %>
</body>
</html>