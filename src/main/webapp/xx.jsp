<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="obj.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>お客様情報</title>

</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>User Id</th>
				<th>Email</th>
				<th>LastName</th>
				<th>FirstName</th>
				<th>LastNameKana</th>
				<th>FirstNameKana</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<User> userList = (List<User>) request.getAttribute("userList");
			if (userList != null) {
				for (User user : userList) {
			%>
			<tr>
				<td><%=user.getUserId()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getLastNameKana()%></td>
				<td><%=user.getFirstNameKana()%></td>

			</tr>
			<%
			}
			}
			%>

		</tbody>
</body>
</html>