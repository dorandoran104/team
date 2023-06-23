<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jsp"%>
<%@ include file="../include/navbar.jsp"%>

<div class="container">

	<form action="new" method="post">

		<div class="mb-3">
			<label for="title" class="form-label">Title</label> 
			<input type="text" class="form-control" id="title" name="title">
		</div>
		<div class="mb-3">
			<label for="body" class="form-label">Example textarea</label>
			<textarea class="form-control" id="body" name="body" rows="3"></textarea>
		</div>
		<button class="btn btn-outline-secondary" type="submit">작성</button>
		
	</form>
	<button class="btn btn-outline-secondary" onclick="history.back()">뒤로가기</button>
</div>

<%@ include file="../include/footer.jsp"%>