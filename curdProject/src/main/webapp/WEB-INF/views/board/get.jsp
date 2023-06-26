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
	      <th scope="col">내용</th>
	      <th scope="col">작성일</th>
	    </tr>
	  </thead>
	  <tbody>
	  	
	    <tr>
	      <td>${board.id}</td>
	      <td>${board.title}</td>
	      <td>${board.body}</td>
	      <td><fmt:formatDate value="${board.regDate}" type="both" dateStyle="short" timeStyle="short"/> </td>
	    </tr>
	  </tbody>
	</table>
	
	<button class="btn btn-outline-secondary" onclick="location.href='modify/${board.id}'">수정</button>
	<button class="btn btn-outline-secondary" id="delete" data-id="${board.id}">삭제</button>
	<button class="btn btn-outline-secondary" onclick="location.href='/curdProject'">목록</button>
	
</div>

<script src="../js/board/get.js"></script>

<%@ include file="../include/footer.jsp" %>