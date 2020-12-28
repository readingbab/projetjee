<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="supprimerchambre">
<table>
<tr>
<td> ville hotel:  </td>
<td> <input type="text" name="ville_hotel" /></td>
</tr>
<tr>
<td> nom hotel:  </td>
<td> <input type="text" name="nom_hotel" /></td>
</tr>
<tr>
<td> numero de chambre  </td>
<td> <input type="number" name="numero_chambre" /></td>
</tr>

<tr> <td> <input type="submit"> </td> </tr>
</table>
</form>
<p >${ str } </p>
</body>
</html>