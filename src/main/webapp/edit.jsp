<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.food_item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%food_item item=(food_item)request.getAttribute("item"); %>

<form action="update" method="post" enctype="multipart/form-data">
	    <input type="text" name="ID" value="<%=item.getId()%>" hidden="">
	    <br>
		<br>
		Name:<input type="text" name="name" value="<%=item.getName()%>">
		<br>
		<br>
		Price:<input type="text" name="price" value="<%=item.getPrice()%>">
		<br>
		<br>
		Quantity: <input type="text" name="quantity" value="<%=item.getQuantity()%>">
		<br>
		<br>
		Food type:
		<%if(item.getType().equals("veg")){ %>
		<input type="radio" name="type" value="veg" checked="checked">Veg<br>
		<input type="radio" name="type" value="non-veg">Non-Veg<br>
		<%}else{ %>
		<input type="radio" name="type" value="veg" >Veg<br>
		<input type="radio" name="type" value="non-veg" checked="checked">Non-Veg<br>
		<%}%>
		<br>
		<br>
		Picture:
		 <%String base64 = Base64.encodeBase64String(item.getPicture());%> 
   <img height="50px" width="50px" alt="unknown"
	src="data:image/jpeg;base64,<%=base64%>">
	<br>
	<input type="file" name="img"><br>
	<button>Update</button>
	</form>




</body>
</html>