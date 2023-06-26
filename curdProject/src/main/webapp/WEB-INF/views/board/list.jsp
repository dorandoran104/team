<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/navbar.jsp" %>
<link rel="stylesheet" type="text/css" href="css/board/list.css">

<div class="container">
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성일</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  </tbody>
	</table>
	<button class="btn btn-outline-secondary" onclick="location.href='boards/new'">작성</button>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination">
		<c:forEach var="count" begin="1" end="${count}" step="1">
			<li class="page-item"><a class="page-link" data-page="${count}">${count}</a></li>
		</c:forEach>
		</ul>
	</nav>
</div>

<script src="js/board/list.js"></script>

<%@ include file="../include/footer.jsp" %>