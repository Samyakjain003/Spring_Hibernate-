<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype Html>
<html>

<head>
	<title>Student Confirmation Form</title>
</head>

<body>

	The Student is confirmed ${student.firstName} ${student.lastName}
	<br>
	
	Country: ${student.country}

	<br>
	 
	 Favorite Language: ${student.favoriteLanguage}
	 
	 <br>
	 
	 Operating System(s): 
	 <ul>
	 	<c:forEach var="temp" items="${student.operatingSystems}">
	 	
	 	<li>${temp}</li>
	 	
	 	</c:forEach>
	 	
	 </ul>
</body>

</html>