<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<P> Welcome user: ${sessionScope.user.username} </P>
<p> <a href="/SpringMVCRegistrationEx/logout">Logout</a>
</body>
</html>
