<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Enregistrermodifhotel">
<table>
<tr>
<td>nom de l'hotel</td>
<td> <input type="text" name="nom_hotel" value="${hotel.nom}" /></td> 
</tr>
<tr>
<td>ville de l'hotel</td>
<td> <input type="text" name="ville_hotel" value="${hotel.ville }" /></td> 
</tr>
<tr>
<td>addresse</td>
<td> <input type="text" name="address_hotel" value="${hotel.adresse }"/></td> 
</tr>
<tr>
<td>nombre des chambres </td>
<td> <input type="text" name="nombre_chambre" value="${hotel.nombre_chambre}" /></td> 
</tr>
<tr>
<td>nombre des etoiles</td>
<td> <input type="text" name="nombre_etoile" value="${hotel.nombre_etoile}" /></td> 
</tr>
<tr>
<td><input type="submit" /></td>
<tr>
</table>
</form>
</body>
</html>