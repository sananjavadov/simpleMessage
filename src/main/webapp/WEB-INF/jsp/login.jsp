<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<center>${errorMessage}</center></br>   
<form:form action="/login" method="POST"   modelAttribute="login">
<center>
İstifadəçi adı</br>
<form:input path="username"/></br></br>
Şifrə</br>
<form:password path="password"/></br></br>
<form:button>Daxil ol</form:button>
</center>
</form:form>