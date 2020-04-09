<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Index Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	String contextPath = (String) request.getContextPath();
%>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=contextPath%>/style/application.css"
	rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/script/app.js"></script>	

</head>
<body class="container">
	
	<label for="login" class="login_text">Welcome to home page</label>
	<h2 id="service-one-response"></h2>
	<div class="login_container">
		<div class="button_padding">
			<button type="button" class="btn btn-default" onclick="javascript:callServiceOne()">Invoke Service One</button>
		</div>
	</div>
	
</body>
</html>