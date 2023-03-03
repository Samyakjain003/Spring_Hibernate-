<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype Html>
<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>

	The customer is confirmed: ${customer.firstName} ${customer.lastName} having passes ${customer.freePasses}
	<br>
	Postal Code: ${customer.postalCode}
	<br>
	Course Code: ${customer.courseCode}
</body>

</html>