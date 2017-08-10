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
		<div class="row">
			<div class="col-md-10 text-center">
				<h1>Bulletin de salaire</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10"></div><div class="col-md-2 text-primary"><h3>Période</h3></div>
		</div>
		<div class="row">
			<div class="col-md-10"></div><div class="col-md-2">${bulletin.periode}</div>
		</div>
		<div class="row">
			<div class="col-md-2 text-primary"><h3>Entreprise</h3></div>
		</div>
		<div class="row">
			<div class="col-md-2">${bulletin.remunerationEmploye.entreprise.denomination}</div>
		</div>
		<div class="row">
			<div class="col-md-10">SIRET: ${bulletin.remunerationEmploye.entreprise.siret}</div><div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-10"></div><div class="col-md-2 text-primary"><h3>Matricule : ${bulletin.remunerationEmploye.matricule}</h3></div>
		</div>
		
		<div class="row">
  			<div class="col-md-12 text-primary"><h3>Salaire</h3></div>
  		</div>
		<div class="row">
  			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Rubriques</th>
							<th>Base</th>
							<th>Taux salarial</th>
							<th>Montant salarial</th>
							<th>Taux patronal</th>
							<th>Cotisations patronale</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
  			<div class="col-md-12 text-primary"><h3>Cotisations</h3></div>
  		</div>
		<div class="row">
  			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Code</th>
							<th>Libelle</th>
							<th>Taux salarial</th>
							<th>Taux patronal</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables}" var="cotisation">
							<tr>
								<td>${cotisation.code}</td>
								<td>${cotisation.libelle}</td>
								<td>${cotisation.tauxSalarial}</td>
								<td>${cotisation.tauxPatronal}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
  			<div class="col-md-12 text-primary"><h3>Net imposable: ${bulletin.resultat.netImposable}</h3></div>
  		</div>
		<div class="row">
  			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Rubriques</th>
							<th>Base</th>
							<th>Taux salarial</th>
							<th>Montant salarial</th>
							<th>Taux patronal</th>
							<th>Cotisations patronale</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
</body>
</html>