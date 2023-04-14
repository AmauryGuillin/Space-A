<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome !</h1>

	<c:forEach items="${userList}" var="users">
		<tr>
			<td>${users.id}</td>
			<td>${users.username}</td>
			<td><a href="delete?id=${users.id}">Delete</a></td>
		</tr>
	</c:forEach>

</body>
</html>