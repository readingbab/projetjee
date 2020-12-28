<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome-free-5.11.2-web\css\all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/indexuser.css">
    <title>Acceuil</title>
</head>

<body>

<c:if test="${sessionScope.message!=null}">
<script> window.alert("${sessionScope.message}")</script> 
</c:if>
<form method="post" action="loginservlet">
 <input type="hidden" name="deconnecteruser" value="deconnecteruser" />
  <input type="submit" value="déconnecter"/>
</form>

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
            <div class="dropdown">
                <div class="user dropbtn">
                    <i class="fas fa-user" style="font-size:48px;"></i>
                </div>
                <div class="dropdown-content">
                    <a href="#">Parametres de compte</a>
                    <a href="${pageContext.request.contextPath}/reservationuser?type=true">mes Reservations</a>
                    <a href="#">mes Reclamations</a>
                </div>
            </div>
        </nav>
    </div>
    <div class="section1 ">
        <form action="Changeuser" method="POST">
            <div class="firstinput">
                <div class="input"><label for="nom">Nom:</label><input type="text" id="nom" name="nom" value="<c:out value="${sessionScope.session_user.nom}" />"></div>
                <div class="input"><label for="prenom">Prenom:</label><input type="text" id="prenom" name="prenom" value="<c:out value="${sessionScope.session_user.prenom}" />"></div>
                <div class="input"><label for="cin">CIN:</label><input  type="text" id="cin" name="cin" value="<c:out value="${sessionScope.session_user.cin}" />"></div>
                <div class="input"><label for="mdp">Mot de passe:</label><input type="text" id="mdp" name="mdp" value="<c:out value="${sessionScope.session_user.password}" />">
                </div>
            </div>
            <div class="secondinput">
                <div class="input"><label for="mdpc">confirmer Mot de passe:</label><input type="text" id="mdpc"
                        name="mdpc"></div>
                <div class="input"><label for="phone">Telephone</label><input type="text" id="phone" name="phone" value="<c:out value="${sessionScope.session_user.phone}" />">
                </div>
                <div class="input"><label for="email">Email</label><input type="text" id="email" name="email" value="<c:out value="${sessionScope.session_user.email}" />">
                </div>
                <div class="input"><label for="addr">Adresse</label><input type="text" id="addr" name="addr" value="<c:out value="${sessionScope.session_user.addresse}" />">
                </div>
            </div>
            <input type="hidden" id="type" name="type" value="change">
            <input type="submit" class="submit" value="changer mes informations">
        </form>
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

</html>