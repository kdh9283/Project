<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-2.2.3.min.js"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		var formObj=$("form[role='form']");
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/board/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});
		
		$(".btn-primary").on("click", function(){
			self.location="/board/list";
		});
		
	});
</script>

</head>
<body>

<form role="form" method="post">
	<input type="hidden" name="bno" value="${read.bno }">
</form>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${read.title }" readonly="readonly">
	</div>
	
	<div class="form-group">
		<label for="exampleInputPassword1">Content</label>
		<textarea class="form-control" name="content" rows="3" readonly="readonly">${read.content }</textarea>
	</div>
	
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${read.writer }" readonly="readonly">
	</div>
</div>

<!-- /.box-body -->

<div class="box-footer">
	<button type="submit" class="btn btn-warning">Modify</button>
	<button type="submit" class="btn btn-danger">Remove</button>
	<button type="submit" class="btn btn-primary">List All</button>
</div>

<%@include file="../include/footer.jsp" %>
</body>
</html>














