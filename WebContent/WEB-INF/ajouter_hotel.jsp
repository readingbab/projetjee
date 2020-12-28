<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ajouterhotel">
<p>
<label for="nom_hotel">nom de l'hotel :</label>
<input type="text" name="nom_hotel" />
</p>
<p>
<label for="ville_hotel">ville de l'hotel</label>
<input type="text" name="ville_hotel" />
</p>
<p>
<label for="addresse_hotel">addresse</label>
<input type="text" name="addresse_hotel" />
</p>

<p>
<label for="nombre_chambre">nombre des chambres :</label>
<input type="text" name="nombre_chambre" />
</p>
<p>
<label for="nombre_etoile">nombre des etoile</label>
<input type="text" name="nombre_etoile" />
</p>

<input type="submit" value="enregistrer" />
<p>
</body>
</html>