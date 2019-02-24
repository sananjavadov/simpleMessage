<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="/regresult" method="POST"   modelAttribute="user">
<center>

İstifadəçi adı</br>
<form:input path="username"/></br></br>
Şifrə</br>
<form:password path="password"/></br></br>
Ad</br>
<form:input path="name"/></br></br>
Soyad</br>
<form:input path="surname"/></br></br>
<div class="g-recaptcha" data-sitekey="6LcQu4UUAAAAAFuHAtuW8yS4ze96wqWAS309_jBC"></div></br>
<form:button>Qeydiyyat</form:button>
</center>
</form:form>
