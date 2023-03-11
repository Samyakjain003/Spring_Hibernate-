<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

	<title>Home page</title>

</head>

<body>
	<h2>Company Home Page - Yoohoo!!</h2>

	<hr>
	<p>
	Welcome to the company home page!
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
				method="POST">
				
		<input type="submit" value="Logout"/>
	
	</form:form>
</body>
</html>