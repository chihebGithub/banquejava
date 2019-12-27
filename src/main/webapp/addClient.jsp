<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" media="screen" href="./css/bootstarp.css">
<meta charset="UTF-8">
<title>Ajouter Client</title>
</head>
<body>

 <form id="myForm" action="ClientController" method="post">  
<table>  
<tr>
<td>Cin:</td><td><input type="text" required="required" id="cin" name="cin"/></td>
<td><label for="email" class="error">This must be a valid email address</label></td>
</tr> 

<tr><td>First Name:</td><td><input type="text"  id="name" name="name"/></td>
    <td><span id="errname"></span> </td>
</tr>  
<tr><td>Last name :</td><td><input type="text" required="required" id="lastname" name="lastname"/></td>
      <td><span id="errlastname"></span> </td>
</tr>  
<tr><td>Email:</td><td><input type="email" required="required" id="email" name="email"/></td>
   <td><span id="erremail"></span> </td>
</tr>  
<tr><td>Sex:</td><td>  
<input type="radio" id="male" name="sex" value="male"/>Male   
<input  type="radio" id="female" name="sex" value="female"/>Female </td>
<td><span id="errSex"></span> </td>

</tr>  
<tr><td>Country:</td><td>  
<select name="country"  id ="country" style="width:155px">  
<option>Tunisia</option>  
<option>Franse</option>  
<option>Afghanistan</option>  
<option>Berma</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td>Adress:</td><td>
<textarea id="Adress" rows="4" cols="50" name="adress">

</textarea>
</td></tr>  
<tr><td colspan="2"><input id="valider" type="submit" value="Add Client"/></td></tr>  
</table>  
</form>
<script src="./js/jquery-3.4.1.min.js" ></script>  
<script src="./js/jquery.validate.js"></script>
<script src="./js/bootstrap/bootstarp.js"></script>
<script>
$(document).ready(function() {
	/*$("#cin").blur(function() {
if($("#cin").val()=="")	$("#errmsg").text("veuillez indiquer le numéro de la carte Cin").css("color", "red").show();;
if($("#cin").val()!="")	$("#errmsg").text("").hide();
});
*/
/*
//$('#valider').prop('disabled', true);
	validation("cin","errmsg","veuillez indiquer le numéro de la carte Cin");
	validation("name","errname","veuillez indiquer votre nom ");
	validation("lastname","errlastname","veuillez indiquer votre prenom ");
	validation("email","erremail","veuillez indiquer votre email ");
	


		//$('#Adress').blur(function (){
		 if($('input[name=sex]:checked').length!=0){
			 console.log($('input[name=sex]:checked').length)
			 $('#valider').prop('disabled', false);
		
		 }
		 
		//});
		*/
		$("#myForm").validate()
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
});


/*
function validation(p1,champerr ,p2) {
	console.log("#"+p1);
	$("#"+p1).blur(function() {
		if($("#"+p1).val()=="")	$("#"+champerr).text(p2).css("color", "red").show();
		if($("#"+p1).val()!="")	$("#errmsg").text("").hide();
	});
	}*/


</script>
</body>
</html>