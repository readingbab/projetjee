<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>les resultats de recherche est :</h1>
<form method="post" action="reservation" >
<ul>
	<c:forEach var="chambre" items="${ chambres }" varStatus="status" >
	<li><img src="${chambre.type_chambre}.jpg" alt="${chambre.type_chambre }.jpg"> <c:out  value="le counteur :${status.count } NOMBRE de place  : ${ chambre.nombre_place} type : ${chambre.type_chambre } prix par jour ${ chambre.prix_jour }"></c:out> <input type="number" name="${status.count}" max="${ chambre.numero_chambre }" min="0" value="0"></li>
	</c:forEach>
</ul>
<input type="submit" />
</form>
</body>
</html>

