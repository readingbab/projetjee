<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylehotel1.css">
    <title>HOTELS</title>
</head>

<body>
<c:if test = "${check}">
<div class="container">
        <div class="timer"></div>
        <div class="slideshow">
            <div class="slide"> <img src="data:image/jpg;base64,${photos[0].base64Image}" alt=""></div>
            <div class="slide"><img src="data:image/jpg;base64,${photos[1].base64Image}"alt=""></div>
            <div class="slide"><img src="data:image/jpg;base64,${photos[2].base64Image}" alt=""></div>
        </div>
    </div>
    </c:if>
    <script src="${pageContext.request.contextPath}/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/apphotel1.js"></script>
    <div class="info">
 <form method="post" action="gerer_hotel?id_hotel=${param.id_hotel}">
id <c:out value="${hoteldata.hotel.id}" /></br>
<label for="nom">Nom Hotel</label>
    <input type="text" id="nom" name="nom" value="${hoteldata.hotel.nom}" > 
    <label for="nom">Ville Hotel</label>
    <input type="text" id="nom" name="ville" value="${hoteldata.hotel.ville}" disabled> 
    <label for="nom">addresse Hotel</label>
    <input type="text" id="nom" name="addresse" value="${hoteldata.hotel.adresse}" disabled> 
    <label for="nom">nombre chambres</label>
    <input type="number" id="nom" name="nombre_chambre" value="${hoteldata.hotel.nombre_chambre}" disabled > 
       <label for="nom">nombre etoile</label>
    <input type="text" id="nom" name="nombre_etoile" value="${hoteldata.hotel.nombre_etoile}"> 
    <input type="submit" value="enregistrer">
</form>   
receptionniste<c:out value="${hoteldata.nombre_receptionniste}" /></br>
local<c:out value="${hoteldata.nombre_local}" /></br>
annuler<c:out value="${hoteldata.nombre_reservation_annuler}" /></br>
valider<c:out value="${hoteldata.nombre_reservation_valider}" /></br>
encore<c:out value="${hoteldata.nombre_reservation_encore}" /></br>
total<c:out value="${hoteldata.nombre_reservation_total}" /></br>
note<c:out value="${hoteldata.note}" /></br>
reclamations<c:out value="${hoteldata.nombre_reclamations}" /></br>
<c:if test = "${!check}">
  <form action="UploadServlet?id_hotel=${param.id_hotel}" method="post" enctype="multipart/form-data">
		
		Select File 1:<input type="file" name="fname1" accept=".jpg,.png,.bmp,.gif" /><br /> 
		Select File 2:<input type="file" name="fname2" accept=".jpg,.png,.bmp,.gif" /><br /> 
		Select File 3:<input type="file" name="fname3" accept=".jpg,.png,.bmp,.gif" /><br /> 
		<input type="submit" value="upload" />
	</form>
	</c:if>
	</div>
</body>
</html>