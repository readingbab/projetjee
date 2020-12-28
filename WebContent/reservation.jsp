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
<style>
.nav{
    list-style: none;
    display:flex;
    width:100%;
    justify-content: space-around;
    height: 10vh;
    color:black;
}
a{
    text-decoration: none;
}
</style>
<body>
<form method="post" action="loginservlet">
 <input type="hidden" name="deconnecteruser" value="deconnecteruser" />
  <input type="submit" value="déconnecter"/>
</form>
 <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/reservationuser?type=true">validé</a></li>
        <li><a href="${pageContext.request.contextPath}/reservationuser?type=false">en cours</a></li>
        <li><a href="${pageContext.request.contextPath}/reservationuser?type=annuler">annuler</a></li>
    </ul>
<c:forEach items="${reservations}" var="r" varStatus="i">
reservation N°: ${i.count} <br>
<ul>
<li> date de debut: <c:out value="${r.reservation.date_debut}" /> </li>
 <li> date de fin <c:out value="${r.reservation.date_fin}" /> </li>
<li> id hotel <c:out value="${r.reservation.id_hotel}" /> <br> </li>
<li>numero chambre <c:out value="${r.reservation.numero_chambre}" /> </li>
<li> Hotel: <c:out value="${r.hotel}"/> </li>
<c:if test="${param.type=='false'}">
<li><form action="reservationuser" method="POST">
 <input type="hidden" id="reservationId" name="reservationId" value="${r.reservation.id_reservation}">
 <input type="hidden" id="type" name="type" value="annuler">
        <button type="submit" value="Annuler">Annuler</button>
    </form></li>
    </c:if>
</ul>
</c:forEach>
</body>
</html>
</body>
</html>