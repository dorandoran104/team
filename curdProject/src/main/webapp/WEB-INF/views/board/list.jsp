<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/navbar.jsp" %>

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
	  	<c:forEach var="list" items="${list}">
	    <tr>
	      <td>${list.id}</td>
	      <td><a href="boards/${list.id}">${list.title}</a></td>
	      <td><fmt:formatDate value="${list.regDate}" type="both" dateStyle="short" timeStyle="short"/> </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<button class="btn btn-outline-secondary" onclick="location.href='boards/new'">작성</button>
</div>

<%@ include file="../include/footer.jsp" %>