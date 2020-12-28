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
<c:url value="/ajouteremploye"></c:url>
<a href="/s3/ajouteremploye">ajouter employer</a>
<a href="/s3/modifieremploye">modifier_employer</a>
<a href="/s3/supprimeremploye">supprimer_employer</a>

<br>
<a href="/s3/ajouterchambre">ajouter chambre</a>
<a href="/s3/modifierchambre">modifier chambre</a>
<a href="/s3/supprimerchambre">supprimer chambre</a>
</body>
</html>