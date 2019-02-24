<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://www.google.com/recaptcha/api.js'></script>
<title>Insert title here</title>
</head>
<body>
<center>
<c:choose>
<c:when test="${userSession!=null}"><a href="/">${userSession.getName()} ${userSession.getSurname()}</a> | <a href="/logout">Çıxış</a></c:when>
<c:otherwise><a href="/reg">Qeydiyyat</a> | <a href="/login">Daxil ol</a></c:otherwise>
</c:choose>
</center><br/>
<c:if test="${includePage!=null}"><jsp:include page="${includePage}" /></c:if>
</body>
</html>

