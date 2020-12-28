<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Enregistrermodifemploye">
<table>

<tr>
<td>cin :</td>
<td><input type="text"  name="cin" value="${rec.cin }" /> </td>
</tr>
<tr>
<td>nom :</td>
<td><input type="text" disabled="disabled" name="nom" value="${rec.nom }" /> </td>
</tr>
<tr>
<td>prenom :</td>
<td><input type="text" disabled="disabled" name="prenom" value="${rec.prenom }" /> </td>
</tr>
<tr>
<td>email :</td>
<td><input type="text"  name="email" value="${rec.email }" /> </td>
</tr>

<tr>
<td>telephone :</td>
<td><input type="text"  name="telephone" value="${rec.telephone }" /> </td>
</tr>


<tr>
<td>addresse :</td>
<td><input type="text"  name="addresse" value="${rec.addresse }" /> </td>
</tr>

<tr>
<td>mot passe :</td>
<td><input type="text"  name="mot_passe" value="${rec.mot_passe }" /> </td>
</tr>

<tr>
<td>ville hotel :</td>
<td><input type="text"  name="ville_hotel" value="${rec.ville_hotel }" /> </td>
</tr>
<tr>
<td>nom hotel :</td>
<td><input type="text"  name="nom_hotel" value="${rec.nom_hotel }" /> </td>
</tr>
<tr>
<td> <input type="submit" > </td>
</tr>
</table>

</form>
</body>
</html>