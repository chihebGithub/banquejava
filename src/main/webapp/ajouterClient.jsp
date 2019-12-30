<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%
HttpSession masession = request.getSession();
String login = (String)masession.getAttribute("uname");
if(login==null){response.sendRedirect("login.jsp");  }
%>

<!DOCTYPE html>
<html>
<head>
<title>web Banque</title>
<meta charset="utf-8">
<link rel="stylesheet" media="screen"
	href="./css/bootstrap/bootstarp.css">
<link rel="stylesheet" media="screen"
	href="./css/bootstrap/bootstrap.min.css">
<script src="./js/jquery-3.4.1.min.js"></script>
<script src="./css/bootstrap/bootstrap.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="ajouterClient.jsp">Banque Web Site</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown">
				<select name="forma" onclick="location = this.value;"
					class="form-control" id="type" name="type">

						<option value="Versement.jsp">versement</option>
						<option value="Retrait.jsp">Retrait</option>
						<option value="Virement.jsp">Virement</option>
				</select>
					</li>
				

			</ul>
			<ul class="mx-auto text-light">
				<% ServletContext my_context = this.getServletContext();
String message = (String)my_context.getAttribute("message"); out.print("hello "+message); %>

			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				</form>	
				<form class="form-inline my-2 my-lg-0" action="LoginController" method="post">
				<button class="btn btn-info btn-lg my-2 my-sm-0" type="submit">Déconnexion</button>
			   </form>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<div class="card bg-light mb-3 "
					style="max-width: 18rem; margin-top: 20px">
					<div class="card-header text-light bg-dark">Navigation</div>
					<div class="card-body">
						 <a href="Versement.jsp" class="btn btn-link">Versement</a>
					
                       <a href="Retrait.jsp" class="btn btn-link">Retrait</a>
                        <a href="Virement.jsp" class="btn btn-link">Virement</a>
                         <a href="ListeCompte" class="btn btn-link">Lister tous les Comptes</a>
                          <a href="ListeCompteClientController" class="btn btn-link">Comsulter mes Comptes</a>
					</div>
				</div>
				<div class="card bg-light mb-3" style="max-width: 18rem;">
					<div class="card-header text-light bg-dark">Administration</div>
					<div class="card-body">
						<h5 class="card-title">Light card title</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					</div>
				</div>
				<div class="card bg-light mb-3" style="max-width: 18rem;">
					<div class="card-header text-light bg-dark">Horloge</div>
					<div class="card-body">
						<h5 class="card-title font-italic">date :</h5>
						 <h6>  <% Date date = new Date();
         out.print( "<h6 align = \"center\">" +date.toString().toLowerCase()+"</h6>");
      %></h6>
					</div>
				</div>

			</div>


			<div class="col-sm-8">

				<div class="card" style="margin-top: 20px; margin-left: -120px;">
					<div class="card-header font-weight-bold text-center">Banque
						en ligne : le comparatif des offres</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<p>Un compte, une carte bancaire gratuite et des frais
								réduits, le tout avec une prime de bienvenue de 60 à 120 € à
								l'ouverture : c'est la promesse alléchante des banques en ligne.</p>

						</blockquote>
					</div>
				</div>
				
					<div class="card" style="margin-top: 20px; height:440px; margin-left: -120px;">
					<div class="card-header text-center">Qu'est-ce qu'une offre de bienvenue ?
Il s’agit généralement d’un bonus financier ou d’une exonération temporaire de certains frais, qui récompense l'ouverture d'un premier compte dans la banque. Le plus souvent, et sauf mentions contraires, ces offres sont réservées aux particuliers majeurs, agissant pour leurs besoins privés et dont la résidence fiscale est en France.</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<div class="row">
  <div class="col-sm-6">
    <div class="card" style="height:300px">
      <div class="card-body">
        <h5 class="card-title font-weight-bold text-center">Compte Courant</h5>
        <p class="card-text font-weight-normal">les comptes courants des banques en ligne se caractérisent par une absence de frais sur la carte bancaire et les principales opérations courantes, à condition de remplir certaines conditions : un niveau minimum de revenus, des versements réguliers sur le compte ou encore un usage régulier de la carte bancaire.</p>
        <a href="AjouterCompteCourant.jsp" class="btn btn-primary">Ajouter Compte</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card" style="height:300px">
      <div class="card-body">
        <h5 class="card-title font-weight-bold text-center">Compte Epargne</h5>
        <p class="card-text">Les comptes de paiement Certaines des offres proposées sur cette page sont de simples comptes de paiement. Proches, dans leur usage quotidien, d’un compte de dépôt bancaire traditionnel</p>
        <a href="ajouterCompte.jsp" class="btn btn-primary">Ajouter Compte</a>
      </div>
    </div>
  </div>
</div>

						</blockquote>
					</div>
				</div>








			</div>

		</div>
	</div>









</body>
</html>

