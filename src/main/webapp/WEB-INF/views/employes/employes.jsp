<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des employés</title>
<link rel="stylesheet"
	href="/paie/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="/paie/jquery/jquery-3.2.1.min.js"></script>
<script src="/paie/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
				<li class="active"><a href="#">Employes <span class="sr-only">(current)</span></a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/bulletins">Bulletins</a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/entreprises">Entreprises</a></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="container">
		
		<h1>Liste des employés</h1>
		
		<div class="row">
  			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Matricule</th>
							<th>Entreprise</th>
							<th>Profil</th>
							<th>Grade</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employes}" var="employe">
							<tr>
								<td>${employe.matricule}</td>
								<td>${employe.entreprise.denomination}</td>
								<td>${employe.profilRemuneration.code}</td>
								<td>${employe.grade.code}</td>
								<td><a href=""><span class="glyphicon glyphicon-pencil"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12"><a class="btn btn-primary" href="<%=request.getContextPath()%>/mvc/employes/creer"" role="button"><span class="glyphicon glyphicon-plus"></span></a></div>
		</div>
	</div>
</body>
</html>