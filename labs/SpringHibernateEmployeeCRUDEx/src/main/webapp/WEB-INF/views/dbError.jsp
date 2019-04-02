<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Hibernate Error Page</title>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<body>
<h1>
	Hibernate Error Occurred!  
</h1>

<p> ${exception} </p>
<span> <a href="${contextPath}"> Back </a></span>
</body>
</html>
