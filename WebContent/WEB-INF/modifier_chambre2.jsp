<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<form method="post" action="Enregistrermodifchambre">
<table>

<tr>
<td>numero :</td>
<td><input type="text"  name="numero_chambre" value="${chambre.numero_chambre }" /> </td>
</tr>
<tr>
<td>type :</td>
<td><input type="text"  name="type_chambre" value="${chambre.type_chambre }" /> </td>
</tr>
<tr>
<td>nombre de place  :</td>
<td><input type="text"  name="nombre_place" value="${chambre.nombre_place }" /> </td>
</tr>
<tr>
<td>prix par jour  :</td>
<td><input type="text"  name="prix_jour" value="${chambre.prix_jour }" /> </td>
</tr>
<tr>
<td>id hotel </td>
<td><input type="text"  name="id_hotel" value="${chambre.id_hotel }" /> </td>
</tr>

<tr>
<td> <input type="submit" > </td>
</tr>
</table>

</form>
</body>
</body>
</html>