<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Employee Management App</title>
</head>

<spring:url value="/login" var="loginPath" htmlEscape="true" />

<body>
	<h1>Welcome to Employee Management App!</h1>
	<p> Current Time: ${serverTime} </p>
	<p> <a href="${loginPath}">Login</a>
</body>
</html>
