<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Client</title>
</head>
<body>
 <form action="ClientController" method="post">  
<table>  
<tr><td>Cin:</td><td><input type="text" name="cin"/></td></tr> 
<tr><td>First Name:</td><td><input type="text" name="name"/></td></tr>  
<tr><td>Last name :</td><td><input type="text" name="lastname"/></td></tr>  
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>  
<tr><td>Sex:</td><td>  
<input type="radio" name="sex" value="male"/>Male   
<input type="radio" name="sex" value="female"/>Female </td></tr>  
<tr><td>Country:</td><td>  
<select name="country" style="width:155px">  
<option>Tunisia</option>  
<option>Franse</option>  
<option>Afghanistan</option>  
<option>Berma</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td>Adress:</td><td>
<textarea rows="4" cols="50" name="adress">

</textarea>
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Add Client"/></td></tr>  
</table>  
</form>  

</body>
</html>