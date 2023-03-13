<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
	
	<hr>
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
			(Only for Managers)
		</p>
		<hr>
	</security:authorize>
	
	
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath }/systems">IT Systems Meeting</a>
		(Only for Admins)
	</p>
	<hr>
	</security:authorize>
	
	
	
	<form:form action="${pageContext.request.contextPath}/logout" 
				method="POST">
				
		<input type="submit" value="Logout"/>
	
	</form:form>
</body>
</html>