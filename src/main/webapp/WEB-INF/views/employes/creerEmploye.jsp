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
				<li class="active"><a href="#">Employes <span class="sr-only">(current)</span></a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/bulletins">Bulletins</a></li>
				<li><a href="<%=request.getContextPath()%>/mvc/entreprises">Entreprises</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<h1>Création d'un employé</h1>

		<form data-toggle="validator" method="post" role="form" action="<%=request.getContextPath()%>/mvc/employes/validerCreer">
			<div class="form-group row">
				<label for="matricule-input" class="col-md-2 col-form-label">Matricule</label>
				<div class="col-md-4">
					<input pattern="^[_A-z0-9]{3,}$" class="form-control" type="text" name="matricule"
						id="matricule-input">
				</div>
			</div>
			<div class="form-group row">
				<label for="entreprise-input" class="col-md-2 col-form-label">Entreprise</label>
				<div class="col-md-2">
					<select name="entrepriseId" id="entreprise-input"
						class="form-control">
						<option value="-1">(Choisissez)</option>
						<c:forEach items="${entreprises}" var="entreprise">
							<option value="${entreprise.id}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="profil-input" class="col-md-2 col-form-label">Profil</label>
				<div class="col-md-2">
					<select name="profilId" id="profil-input" class="form-control">
						<option value="-1">(Choisissez)</option>
						<c:forEach items="${profils}" var="profil">
							<option value="${profil.id}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="grade-input" class="col-md-2 col-form-label">Grade</label>
				<div class="col-md-2">
					<select name="gradeId" id="grade-input" class="form-control">
						<option value="-1">(Choisissez)</option>
						<c:forEach items="${grades}" var="grade">
							<option value="${grade.id}">${grade.code}</option>
						</c:forEach>
					</select>
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