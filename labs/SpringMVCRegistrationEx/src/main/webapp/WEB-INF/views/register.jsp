<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration</title>
</head>
<body>
<form action="/SpringMVCRegistrationEx/register/" method="POST">
	<p>Enter Username: <input name="username" type="text" /> </p>
	<p>Enter Password: <input name="password" type="password" /> </p>
	<p><button type="submit" value="Submit">Submit</button> <button type="reset" value="Reset">Reset</button> </p>
</form>
</body>
</html>
