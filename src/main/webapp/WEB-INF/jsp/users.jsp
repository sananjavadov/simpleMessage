<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<center>
<c:forEach var="u" items="${all}"  >
<c:if test="${u.getId()!=userSession.getId()}"><a href="/message/${u.getId()}">${u.getName()} ${u.getSurname()}</a><br/></c:if>
</c:forEach>

</center>