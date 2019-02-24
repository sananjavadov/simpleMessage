<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<center>
<c:choose>
<c:when test="${messages.isEmpty()}">
${partnerUser.getName()} ${partnerUser.getSurname()} ilə  bir mesajınız yoxdur</br>
</c:when>
<c:otherwise>
<c:forEach var="m" items="${messages}">
${m.getSender().getName()} ${m.getSender().getSurname()} : ${m.getContent()}</br>
</c:forEach>
</c:otherwise>

</c:choose>
</br>
<form:form action="/send" method="POST" modelAttribute="sendMessage" >
<form:input path="message" /></br></br>
<form:button>Göndər</form:button>
</form:form>
</center>