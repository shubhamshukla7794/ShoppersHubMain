<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ShoppersHub</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="resources/css/HeaderStyle.css"/>
</head>


<body>

	<nav class="navbar navbar-inverse navbar-fixed-top"	style="background-color: #041633;">
	<div class="container-fluid">
		<div class="navbar-header">
			<c:if test="${sessionScope.loggedIn}">
				<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
					<a class="navbar-brand" href="login_success"></a>
				</c:if>
				<c:if test="${sessionScope.role=='ROLE_USER'}">
					<a class="navbar-brand" href="http://localhost:8080/ShoppersHubMainFrontEnd/"></a>
				</c:if>
			</c:if>
			<c:if test="${!sessionScope.loggedIn}">
				<a class="navbar-brand" href="http://localhost:8080/ShoppersHubMainFrontEnd/"></a>
			</c:if>
		</div>

		<ul class="nav navbar-nav">
			<c:if test="${!sessionScope.loggedIn}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login">LOGIN</a></li>
				<li><a href="register">REGISTER</a></li>
			</ul>
			</c:if>
			<c:if test="${sessionScope.loggedIn}">
				<%-- <c:if test="${sessionScope.role=='ROLE_ADMIN'}">
					<li><a href="login_success">Admin Home</a></li>
				</c:if> --%>
				<c:if test="${sessionScope.role=='ROLE_USER'}">
					<li><a href="<c:url value="/products"/>">Products</a></li>
				</c:if>
			</c:if>
		</ul>

		<!-- <div class="nav nav-bar navbar-right"> -->
			<c:if test="${sessionScope.loggedIn}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Welcome ${sessionScope.username}</a></li>
				<li><a href="perform_logout">LOGOUT</a></li>
                <c:if test="${sessionScope.role=='ROLE_USER'}">
                	<a href="myCart" class="btn btn-primary navbar-btn" style="margin-right:10px">
					<i class="fas fa-shopping-cart"></i>&nbsp;${CartItems}&nbsp;&nbsp;CART</a>
				</c:if>
				</ul>
			</c:if>
		<!-- </div> -->
	</div>
	</nav>
</body>
</html>