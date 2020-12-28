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
<form method="post" action="Loginusers">
 <input type="hidden" name="deconnecterlocal" value="deconnecterlocal" />
  <input type="submit" value="déconnecter"/>
</form>
<h1>local</h1>
<h1>les resultats de recherche est :</h1>
<form method="post" action="Reservationlocal" >
<ul>
	<c:forEach var="chambre" items="${ chambres }" varStatus="status" >
	<li> <c:out  value="le counteur :${status.count } NOMBRE : ${ chambre.numero_chambre} type : ${chambre.type_chambre } prix par jour ${ chambre.prix_jour }"></c:out> <input type="number" name="${status.count}" max="${ chambre.numero_chambre }" min="0" value="0"></li>
	</c:forEach>
</ul>
<select name="validation" >
    <option value="false" selected>non valider</option>
    <option value="true">valider</option>
</select>
<br>
<input type="submit" />
</form>
</body>
</html>