<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>Edit movie</title>
</head>
<body>
<form:form modelAttribute="movie" method="post">
	<form:hidden path="id"/>
	
	<form:errors path="name" />
	Name: <form:input path="name" /><br/>
	
	<form:errors path="duration" />
	Duration <form:input path="duration" /><br/>
	
	<form:errors path="date" />
	Date: <form:input path="date" /><br/>
	
	<input type="submit" value="Save" name="Save" />
</form:form>
</body>
</html>