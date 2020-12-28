<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="post" action="Add_hotel">
      <label for="nom_hotel"><b>Nom Hotel</b></label>
      <input type="text" placeholder="Entrer Un Nom" name="nom_hotel"></br>
      <label for="nom_hotel"><b>Ville Hotel</b></label>
      <input type="text" placeholder="Entrer Un Nom" name="ville_hotel"></br>
      <label for="nom_hotel"><b>Addresse Hotel</b></label>
      <input type="text" placeholder="Entrer Un Nom" name="addresse_hotel"></br>
      <label for="nom_hotel"><b>Nombre etoile</b></label>
      <input type="number" placeholder="Entrer Un Nom" name="etoile_hotel"></br>
      <input type="submit" value="enregistrer" />
      </form>
</body>
</html>