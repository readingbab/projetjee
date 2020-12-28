<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Krajee JQuery Plugins - &copy; Kartik</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/bootstrap-star-rating-master/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
    <!--suppress JSUnresolvedLibraryURL -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap-star-rating-master/js/star-rating.js" type="text/javascript"></script>
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
<form method="post" action="loginservlet">
 <input type="hidden" name="deconnecteruser" value="deconnecteruser" />
  <input type="submit" value="déconnecter"/>
</form>
 <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/reservationuser?type=true">validé</a></li>
        <li><a href="${pageContext.request.contextPath}/reservationuser?type=false">en cours</a></li>
        <li><a href="${pageContext.request.contextPath}/reservationuser?type=annuler">annuler</a></li>
    </ul>
    <c:set var="count" value="0" scope="page" />
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
<c:if test="${param.type=='true'}">
<div class="container">
    <form action="Rate?id=${r.reservation.id_reservation}" method="post">
        <input name="rating" id="input-21b" value="${ratings[count]}" type="text" class="rating" data-min=0 data-max=5 data-step=0.2 data-size="lg"
               required title="">
               <input type="hidden" name="type" value="rate"/>
        <div class="clearfix"></div>
        <hr>
        <div class="form-group" style="margin-top:10px">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
    <hr>
<c:set var="count" value="${count + 1}" scope="page"/>
</div>
</c:if>
<a href="Rate?id=${r.reservation.id_reservation}">Voir reclamations</a>
</ul>
</c:forEach>
  <script>
        jQuery(document).ready(function () {
            $("#input-21f").rating({
                starCaptions: function (val) {
                    if (val < 3) {
                        return val;
                    } else {
                        return 'high';
                    }
                },
                starCaptionClasses: function (val) {
                    if (val < 3) {
                        return 'label label-danger';
                    } else {
                        return 'label label-success';
                    }
                },
                hoverOnClear: false
            });
            var $inp = $('#rating-input');

            $inp.rating({
                min: 0,
                max: 5,
                step: 1,
                size: 'lg',
                showClear: false
            });

            $('#btn-rating-input').on('click', function () {
                $inp.rating('refresh', {
                    showClear: true,
                    disabled: !$inp.attr('disabled')
                });
            });


            $('.btn-danger').on('click', function () {
                $("#kartik").rating('destroy');
            });

            $('.btn-success').on('click', function () {
                $("#kartik").rating('create');
            });

            $inp.on('rating.change', function () {
                alert($('#rating-input').val());
            });


            $('.rb-rating').rating({
                'showCaption': true,
                'stars': '3',
                'min': '0',
                'max': '3',
                'step': '1',
                'size': 'xs',
                'starCaptions': {0: 'status:nix', 1: 'status:wackelt', 2: 'status:geht', 3: 'status:laeuft'}
            });
            $("#input-21c").rating({
                min: 0, max: 8, step: 0.5, size: "xl", stars: "8"
            });
        });
    </script>
</body>
</html>
