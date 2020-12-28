<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Les Reclamations</title>
</head>
<body>
<c:forEach items="${reclamations}" var="r" varStatus="i">
        <p>type de recelemation: ${r.type}</p>
        <p>nom: ${r.nom_client}</p>
        <p>prenom: ${r.prenom_client}</p>
        <p>date debut: ${r.date_debut}</p>
        <p>date fin: ${r.date_fin}</p>
        <p>cin client: ${r.cin_client}</p>
        <p>le texte de réclamation: ${r.text}</p>
        
</c:forEach>
</body>
</html>