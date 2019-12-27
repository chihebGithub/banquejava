<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.banque.beans.Client,java.util.List,com.banque.dao.InterfaceClient,com.banque.dao.ClientImpl"%>  
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Clients</title>
</head>
<body>
  <h1>Displaying Student List</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Student Name</b></th> 
          <th><b>Student Age</b></th> 
          <th><b>Course Undertaken</b></th> 
         </tr> 
        <%List<Client> std = (List<Client>)request.getAttribute("liste");%> 
       <% for(Client s:std){%> 
            <tr> 
               <td><%=s.getCodClt()%></td> 
               <td><%=s.getName()%></td> 
                <td><%=s.getFirstName()%></td> 
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
</body>
</html>