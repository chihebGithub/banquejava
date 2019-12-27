<%@page import="com.banque.beans.Client"%>  

 
<p>Client Ajouter avec succes</p>  
<%  
Client bean=(Client)request.getAttribute("bean");  
 
%> 
 
<table>  
<tr><td>Cin:</td><td><%= bean.getCodClt() %> </td></tr> 
<tr><td>Name:</td><td><%= bean.getName() %> </td></tr>  
<tr><td>Last name :</td><td><%= bean.getFirstName() %> </td></tr>  
<tr><td>Email:</td><td><%= bean.getEmail() %> </td></tr>  
<tr><td>Sex:</td><td><%= bean.getSex() %> </td></tr>  
<tr><td>Country:</td><td><%= bean.getCountry() %> </td></tr>  
<tr><td>password:</td><td><%= bean.getPassword() %> </td></tr>  

</table>
  
<a href="addCompte.jsp">Add New Compte</a>  
