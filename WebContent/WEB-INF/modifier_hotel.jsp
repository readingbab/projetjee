<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylehotel.css">
    <title>HOTELS</title>
</head>

<body>
  <label for="ville">VILLE</label>
                <select id="city" name="ville" class="used">
                    <c:forEach var="villehotel" items="${VilleHotel}">
                          <option value="${villehotel.key}">${villehotel.key}</option>
                      </c:forEach>
                      <option value="All" selected="selected">All</option>
                </select>
    <div class="container">
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="villehotel" items="${VilleHotel}">
                       <c:forEach items="${villehotel.value}" var="hotels"> 
        <div class="gallery" data-ville="${villehotel.key}">
            <a target="" href="gerer_hotel?id_hotel=${id_hotels[count]}">
                <div class="inside">
                    <img src="data:image/jpg;base64,${photos[count].base64Image}" alt="Cinque Terre" width="600" height="400">
                    <div class="desc">${hotels}</div>
                </div>
            </a>
        </div>
        <c:set var="count" value="${count + 1}" scope="page"/>
              </c:forEach>
                  </c:forEach>
    </div>
    <a href="Add_hotel">ajouter hotel</a>
</body>
<script src="${pageContext.request.contextPath}/apphotel.js"></script>
</html>