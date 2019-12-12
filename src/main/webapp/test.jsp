<html>
<head>
  <title>Echoing HTML Request Parameters</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
   <script>
 
 <%--    $(function(){
    	 
         $('input[name="usrname"]').on('blur',function(){
        	 <% String str=(String)request.getAttribute("code"); %>
        	  $s = "<%= str %>"; 
       	  alert ("aaa" + $s);
            $('input[name="usrname"]').val();
         }) ;
      }); --%>
      
      
      $(document).ready(function() {
    		$("#usrname").blur(function() {
    			var n = $("#usrname").val();
   		       $.post("/BanqueApplication/CompteController",{name:n},function(data){
   		             $("#result1").html(data);
   		             alert (data);
   		             })
    	});

      });
  </script> 
</head>

<body>
  <h3>Choose an author:</h3>
  <form action="CompteController" method="post">
 <input type="text" id="usrname" name="usrname"><br>
 <span id ="result1"></span>
<select name="car">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option>

</select>

<input type="submit" value=Query>
</form>

  <%
  String k=request.getParameter("usrname");
  String s=k+request.getParameter("car");
  out.println(s);
   %>
</body>
    
</html>