<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Doctype Html>
<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name:<form:input path="firstName"/>
	
	<br>
	
	Last Name:<form:input path="lastName"/>
	
	<br>
	
	Country:
	
	<form:select path="country">
	
		<form:options items="${student.countryOptions}"/>
		
	</form:select>
	<br>
	
	Favorite Language:
	
	Java:<form:radiobutton path="favoriteLanguage" value="Java"/>
	C#:<form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP:<form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby:<form:radiobutton path="favoriteLanguage" value="Ruby"/>
	
	<br>
	
	Operating Systems:
	
	Linux:<form:checkbox path="operatingSystems" value="Linux"/>
	Windows:<form:checkbox path="operatingSystems" value="Windows"/>
	Mac OS:<form:checkbox path="operatingSystems" value="Mac Os"/>
	
	<br>
	<input type="submit" value="Submit"/>
	
	</form:form>

</body>

</html>