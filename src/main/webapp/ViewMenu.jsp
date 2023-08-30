<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page  import="dto.food_item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<food_item> items=(List<food_item>)request.getAttribute("list");%>

<table border=1>
<tr>
<th>ID</th>
<th>Name</th>
<th>price</th>
<th>type</th>
<th>Quantity</th>
<th>Picture</th>
<th>Edit</th>
<th>Delete</th>
</tr>


<%for(food_item item:items) {%>
<tr>
<td><%=item.getId()%></td>
<td><%=item.getName()%></td>
<td><%=item.getPrice()%></td>
<td><%=item.getType()%></td>
<td><%=item.getQuantity()%></td>
<td>
   <%String base64 = Base64.encodeBase64String(item.getPicture());%> 
   <img height="150px" width="150px" alt="unknown"
	src="data:image/jpeg;base64,<%=base64%>">
</td>
<td><a href="edit"><button>Edit</button></a></td>
                      
<td><a href="delete?id=<%=item.getId()%>"><button>Delete</button></a></td>
</tr>
<%} %>
</table>
<a href="Adminhome.html"><button>Back</button></a>
</body>
</html>