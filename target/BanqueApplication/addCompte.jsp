<!DOCTYPE html>
<html>
<head>

<script src="./js/jquery-3.4.1.min.js" ></script>
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
			dataType: "json",
		    data :{name : n},
			success : function(responseText) {
			    $("#name").val(responseText.name);
			    $("#lastname").val(responseText.firstname);
			  //  alert(responseText)
				
			}
			
		});
		
});

});
</script>
</head>
<body>
   <h1>Add New Compte</h1>
   <form action="AccessCompte" method="post">
   <p></p>
   <span id="result1"></span>
     <table>  
<tr><td>Code Client:</td><td><input type="text" id="cin" name="cin"/></td>
<td><span id="err"><%= request.getAttribute("err") %> </span></td>
</tr> 
<tr><td>First Name:</td><td><input type="text" id="name" name="name" readonly /></td></tr>  
<tr><td>Last name :</td><td><input type="text" id="lastname" name="lastname" readonly/></td></tr>  
<tr><td>type:</td><td>  
<select name="type" style="width:155px">  
<option value="100">Compte Epargne</option>  
<option value="110">Compte Courant</option>  
</select>  
</td></tr>
<tr><td>
<input type="submit" value="Add Compte"/></td></tr>
</table>  
   </form>
</body>
</html>