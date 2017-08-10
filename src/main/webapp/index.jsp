<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAIE</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="jquery/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Accueil</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/mvc/employes">Employes</a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/bulletins">Bulletins</a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/entreprises">Entreprises</a></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<div class="container">
		<h1>SIRH - Gestion de la paie</h1>
	</div>
</body>
</html>