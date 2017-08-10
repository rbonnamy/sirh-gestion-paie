<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Créer employé</title>
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
				<li><a href="<%=request.getContextPath()%>/mvc/employes">Employes </a></li>
				<li class="active"><a href="#">Bulletins <span class="sr-only">(current)</span></a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/entreprises">Entreprises</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<h1>Création d'un bulletin</h1>

		<form data-toggle="validator" method="post" role="form" action="<%=request.getContextPath()%>/mvc/bulletins/validerCreer">
			
			<div class="form-group row">
				<label for="periode-input" class="col-md-2 col-form-label">Période</label>
				<div class="col-md-2">
					<select name="periodeId" id="periode-input"
						class="form-control">
						<option value="-1">(Choisissez)</option>
						<c:forEach items="${periodes}" var="periode">
							<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="matricule-input" class="col-md-2 col-form-label">Matricule</label>
				<div class="col-md-2">
					<select name="matricule" id="matricule-input"
						class="form-control">
						<option value="-1">(Choisissez)</option>
						<c:forEach items="${employes}" var="employe">
							<option value="${employe.matricule}">${employe.matricule}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="prime-input" class="col-md-2 col-form-label">Prime exceptionnelle</label>
				<div class="col-md-4">
					<input pattern="^[0-9]{1,}$" class="form-control" type="text" name="primeExceptionnelle"
						id="prime-input">
				</div>
			</div>
			<div class="input-group">
				<button class="btn btn-primary" type="submit">
					Valider
				</button>
			</div>
		</form>
	</div>
</body>
</html>