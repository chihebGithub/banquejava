<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Add Compte</title>
<script>
$(document).ready(function() {
	$("#cin").blur(function() {
		var n = $("#cin").val();
	    /*   $.post("/BanqueApplication/CompteController",{name:n},function(data){
	    	 
	             $("#name").val(data);
	            // alert (data);
	             })
	             */
	         
		$.ajax({
			url : '/BanqueApplication/CompteController',
			type:'POST',
			data :{name : n},
			success : function(responseText) {
				$('#result1').text(responseText);
				//var Data = $.parseJSON(responseText);
				 alert(responseText);
			}
			
		});
		
});

});
</script>
</head>
<body>
   <h1>Add New Compte</h1>
   <form action="CompteController" method="post">
   <p></p>
   <span id="result1"></span>
     <table>  
<tr><td>Code Client:</td><td><input type="text" id="cin" name="cin"/></td></tr> 
<tr><td>First Name:</td><td><input type="text" id="name" name="name" readonly /></td></tr>  
<tr><td>Last name :</td><td><input type="text" name="lastname" readonly/></td></tr>  

<tr><td>type:</td><td>  
<select name="type" style="width:155px">  
<option>Compte Epargne</option>  
<option>Compte Courant</option>  

</select>  
</td></tr>
<tr><td><input type="submit" value="Add Compte"/></td></tr>
</table>  
     
   
   </form>
</body>
</html>