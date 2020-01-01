<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
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
	href="./css/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<script src="./js/jquery-3.4.1.min.js"></script>
<script src="./css/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
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
				<li class="nav-item"><a class="nav-link" href="#"></a></li>
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
				<% out.print("hello "+login); %>

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
						<h6>
							<% Date date = new Date();
         out.print( "<h6 align = \"center\">" +date.toString().toLowerCase()+"</h6>");
      %>
						</h6>
					</div>
				</div>

			</div>


			<div class="col-sm-8">

				<div class="card"
					style="margin-top: 20px; height: 500px; margin-left: -120px;">
					<div class="card-header font-weight-bold text-center">Ajouter
						Compte Courant</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
						<form action="AccessCompte" method="post">
							<div class="form-group">
							
								<label for="type">Type du Compte </label> <select
									class="form-control" id="type" name="type">
									<option value="110">Compte Courant</option>
								</select>
							</div>

							<div class="form-group">
								<label for="cin">carte identité </label> <input
									type="text" name="cin" id="cin" tabindex="1"
									required="required" class="form-control"
									placeholder="numero carte identité" value="" />
                               <p id="errcin"></p>
							</div>
							<div class="form-group">
								<label for="name">Nom  </label> 
								<input
									type="text" name="name" id="name" tabindex="1" readonly
									required="required" class="form-control"
									placeholder="nom" value="" />

							</div>
								<div class="form-group">
								<label for="lastname">Prenom  </label> 
								<input
									type="text" id="lastname" tabindex="1" name="lastname" readonly
									required="required" class="form-control"
									placeholder="nom" value="" />

							</div>
							<div class="form-group">
							<input type="submit" name="add" class="btn btn-primary" value="Ajouter"/>
                            <button type="reset" class="btn btn-danger">Annuler</button>
                           </div>
                         </form>  
						</blockquote>
					</div>
				</div>





			</div>

		</div>
	</div>









</body>
<script>
$(document).ready(function() {
	$("#cin").blur(function() {
		var n = $("#cin").val();
	    /*   $.post("/BanqueApplication/CompteController",{name:n},function(data){
	    	 
	             $("#name").val(data);
	            // alert (data);
	             })
	             */
	             $("#cin").keypress(function (e) {
	        	     //if the letter is not digit then display error and don't type anything
	        	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        	               return false;
	        	    }
	        	     
	        	   });    
	             
	             
		$.ajax({
			url : '/BanqueApplication/CompteController',
			type:'POST',
			dataType: "json",
		    data :{name : n},
			success : function(responseText) {
				console.log(responseText)
			    $("#name").val(responseText.name);
			    $("#lastname").val(responseText.firstname);
			    
			    if(responseText.errClient!=null)
					{
			    	console.log(responseText.errClient)
			    	  $("#errcin").text(responseText.errClient).show().css("color","red");
					 $("#cin").focus();
					}
					if(responseText.errClient==null)
					{ $("#errcin").hide();
					// $("#emailname").focus();
					}
				
			}
			
		});
		
});

});
</script>




</html>

