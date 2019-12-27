<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*, javax.servlet.*,com.banque.beans.Compte"%>
<%--  
Compte bean=(Compte)request.getAttribute("bean");  
Compte cpt=new Compte();
if(bean!=null){
cpt.setCodNatCpt(bean.getCodNatCpt());
cpt.setCodclt(bean.getCodclt());
cpt.setNumCpt(bean.getNumCpt());
cpt.setSolde(bean.getSolde());

}
String Type ="";
if(bean.getCodNatCpt()==100){Type= "Compte Epargne" ;}
if(bean.getCodNatCpt()==110){Type= "Compte Courant" ;}
--%> 
<%--
HttpSession masession = request.getSession();
String login = (String)masession.getAttribute("uname");
if(login==null){response.sendRedirect("login.jsp");  }
--%>
<%List<Compte> std = (List<Compte>)request.getAttribute("liste");
  double solde =(double)request.getAttribute("sum");
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
		<a class="navbar-brand" href="#">Banque Web Site</a>
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

				<li class="nav-item dropdown"><select name="forma"
					onclick="location = this.value;" class="form-control" id="type"
					name="type">

						<option value="Versement.jsp">versement</option>
						<option value="Retrait.jsp">Retrait</option>
						<option value="Virement.jsp">Virement</option>
				</select></li>


			</ul>
			<ul class="mx-auto text-light">
				<%-- out.print("hello "+login); --%>

			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
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
						<a href="Versement.jsp" class="btn btn-link">Versement</a> <a
							href="Retrait.jsp" class="btn btn-link">Retrait</a>
							 <a
							href="Virement.jsp" class="btn btn-link">Virement</a>
							 <a href="ListeCompte" class="btn btn-link">Lister les Comptes</a>
							
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
					style="margin-top: 20px;  margin-left: -120px;">
					<div class="card-header font-weight-bold text-center">Consulter Tout les Comptes</div>


			
<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
  <thead>
    <tr>
      <th class="th-sm">Code Client

      </th>
      <th class="th-sm">Numero Compte

      </th>
      <th class="th-sm">Solde

      </th>
      <th class="th-sm">Type de Compte

      </th>
   
    </tr>
  </thead>
  <tbody>
   <% for(Compte s:std){%> 
            <tr> 
            <td><%=s.getCodclt()%></td> 
               <td><%=s.getNumCpt()%></td> 
               <td><%=s.getSolde()%></td> 
              
                <% 
                int a = s.getCodNatCpt();
                if(a==100){%> <td>Compte Epargne</td><%}
                else {%><td>Compte Courant</td><%} %>
              
                
            </tr> 
            <%}%> 
  
  
  </tbody>
  <tfoot>
   <tr>
      <td>Total de Solde Disponible </td>
       <td class="text-primary"><%=solde %></td>
    </tr>
	  </tfoot>
</table>
			

			
				</div>





			</div>

		</div>
	</div>



<script type="text/javascript"  src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"  src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>

<script>
$(document).ready(function () {
	  $('#dtBasicExample').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});

</script>





</body>






</html>

