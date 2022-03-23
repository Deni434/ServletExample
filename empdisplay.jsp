
<%@page import="entity.Employee"%>
<%@page import="java.util.ArrayList"%>
<h1>>View All Employee Records</h1>


<% 

  ArrayList<Employee> list = (ArrayList<Employee>)session.getAttribute("elist");

%>

<table border="1">

<tr>

    <th>ID</th>
    <th>Name</th>
    <th>Salary</th>
    <th>Department</th>
    <th>Edit</th>
    <th>Delete</th>

</tr>

<% for(Employee e1: list) {%>


     <tr>
        <td><%=e1.getId() %></td>
        <td><%=e1.getEname() %></td>
        <td><%=e1.getEsalary() %></td>  
        <td><%=e1.getEdepartment() %></td> 
        
        <td><a href="edit?selectedid=<%=e1.getId()%>">Edit</a></td>
        <td><a href="delete?selectedid=<%=e1.getId()%>">Delete</a></td>
      
     </tr>

 <% }%> 



</table>