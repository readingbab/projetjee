<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <title>PFA Hotel multisite</title>
</head>

<body>
   <div class="header">
        <nav>
            <div class="logo">
                <h4>Hotel multi-site</h4>
            </div>
            <ul>
                <li><a href="default.asp">Home</a></li>
                <li><a href="news.asp">News</a></li>
                <li><a href="contact.asp">Contact</a></li>
                <li><a href="about.asp">About</a></li>
            </ul>
        </nav>
    </div>
    <div class="section1">
        <div class="form">
            <form method="post" action="resultat">
                <label for="ville">VILLE</label>
                <select id="ville" name="ville" class="used">
                    <c:forEach var="villehotel" items="${VilleHotel}">
                          <option value="${villehotel.key}">${villehotel.key}</option>
                      </c:forEach>
                </select>
                <label for="nom">Hotel</label>
                <c:forEach var="villehotel" items="${VilleHotel}">
                       <select hidden class="${villehotel.key}" id="${villehotel.key}">
                       <c:forEach items="${villehotel.value}" var="hotels"> 
                              <option value="${hotels}">${hotels}</option>
                              </c:forEach>
                          </select>
                  </c:forEach>
                   <c:forEach var="villehotel" items="${VilleHotel}" varStatus="_status" >
                    <c:if test="${_status.count eq 1}">
                       <select  class="newSel used" id="newSel used" name="nom">
                       <c:forEach items="${villehotel.value}" var="hotels" varStatus="_status1" > 
                        <c:choose>
                          <c:when test="${_status1.count eq 1}">
                          <option selected="selected" value="${hotels}">${hotels}</option>
                           </c:when>
                            <c:otherwise>
                            <option  value="${hotels}">${hotels}</option>
                             </c:otherwise>
                                  </c:choose>      
                              </c:forEach>
                          </select>
                           </c:if>
                  </c:forEach>
                <label for_debut="date">date de reserve</label>
                <input min="<%= java.time.LocalDate.now()%>" onchange="document.getElementById('date_fin').min=this.value;" type="date" id="date_debut" name="date_debut" placeholder="yyyy-mm-dd">
               
                <label for="date_fin">date de reserve</label>
                <input min="<%= java.time.LocalDate.now()%>" type="date" id="date_fin" name="date_fin" placeholder="yyyy-mm-dd">
                <input type="submit" value="Rechercher">
            </form>
        </div>
        <div class="image">
            <img src="hotel.jpg" alt="hotel.jpg">
        </div>
    </div>
     <footer class="page-footer">
        <div class="container">
            <ul>
                <li><a href="default.asp">Contact Us</a></li>
                <li><a href="news.asp">FAQ</a></li>
                <li><a href="contact.asp">Services</a></li>
                <li><a href="about.asp">About</a></li>
            </ul>
        </div>
        <div class="footer-copyright">
            <div class="container">
                © 2019 Copyright Text
            </div>
        </div>
    </footer>


</body>
<script src="${pageContext.request.contextPath}/jquery-3.4.1.min.js"></script>z
<script >
var ville = document.getElementById("ville");
ville.addEventListener('change', function (e) {
    var oldSel = $('.newSel').get(0);

    while (oldSel.options.length > 0) {
        oldSel.remove(oldSel.options.length - 1);
    }
    var valeur = ville.value;
    console.log(valeur);
    var newSel = $('.' + valeur).get(0);

    for (i = 0; i < newSel.length; i++) {
        var opt = document.createElement('option');

        opt.text = newSel.options[i].text;
        opt.value = newSel.options[i].value;

        oldSel.add(opt, null);
    }
});

</script>
</html>