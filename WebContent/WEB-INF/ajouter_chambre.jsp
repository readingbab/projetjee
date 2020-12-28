<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>page d'ajoute des nouveaux chambres </h1>
<form method="post" action="ajouterchambre">
<table>
<tr>
<td>ville hotel</td>
<td> <input type='text' name='ville_hotel' /> </td>
</tr>
<tr>
<td>nom hotel</td>
<td> <input type='text' name='nom_hotel' /> </td>
</tr>
<tr>
<td>numero chambre</td>
<td> <input type='text' name='numero_chambre' /> </td>
</tr>
<tr>
<td>nombre de place</td>
<td> <input type='text' name='nombre_place' /> </td>
</tr>
<tr>
<td>prix par jour </td>
<td> <input type='text' name='prix_jour' /> </td>
</tr>
<tr>
<td>type_chambre</td>
<td> <input type='text' name='type_chambre' /> </td>
</td>
</table>
<input type="submit" />
</form>
</body>
</html>