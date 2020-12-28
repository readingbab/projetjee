<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/datatables.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styleRecep.css">
<title>Gestion Clients</title>
</head>
<body>
<form method="post" action="Loginusers">
 <input type="hidden" name="deconnecterlocal" value="deconnecterlocal" />
  <input type="submit" value="déconnecter"/>
</form>
<h1>local</h1>

<c:if test="${sessionScope.messagelo!=null}">
<script> window.alert("${sessionScope.messagelo}")</script> 
</c:if>
    <div class="card-body">
        <div class="table-responsive">
            <table style="width:100%" id="example" class="table table-bordered table-hover nowrap ">
                <thead class="bg-primary">
                    <tr>
                        <th scope="col" style="width:15%;color: black;">CIN</th>
                        <th scope="col" style="width:15%;color: black;">Nom</th>
                        <th scope="col" style="width:15%;color: black;">Prenom</th>
                        <th scope="col" style="width:15%;color: black;">Telephone</th>
                        <th scope="col" style="width:15%;color: black;">Email</th>
                        <th scope="col" style="width:30%;color: black;">Adresse</th>
                        <th scope="col" style="width:10%;color: black;">MOT DE PASSE</th>
                         <th scope="col" style="width:10%;color: black;">Rservations</th>
                        <th scope="col" style="width:30%;color: black;">parametre</th>

                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${clients}" var="value" varStatus="i">
                    <tr>
                        <td><c:out value="${value.cin}"/></td>
                        <td><c:out value="${value.nom}"/></td>
                        <td><c:out value="${value.prenom}"/></td>
                        <td><c:out value="${value.phone}"/></td>
                        <td><c:out value="${value.email}"/></td>
                        <td><c:out value="${value.addresse}"/></td>
                        <td><c:out value="${value.password}"/></td>
                        <td><a href="gestion_reservations?cin=${value.cin}&type=true">Afficher Reservations</a></br>
                            <div class="modal fade" id="modaladdform" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold"><b>Remplir les Formules</b></h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body mx-1">
                    <form method="post" action="Resultatlocal">
                        <div class="form-group container-add modalitosmall">
                            <label for_debut="date"><b>date de reserve</b></label>
                            <input type="date" id="date_debut" name="date_debut" min="<%= java.time.LocalDate.now()%>" onchange="document.getElementById('date_fin').min=this.value;" placeholder="yyyy-mm-dd">
							<br>
                            <label for="date_fin"><b>date de reserve</b></label>
                            <input type="date" id="date_fin" name="date_fin" min="<%= java.time.LocalDate.now()%>" placeholder="yyyy-mm-dd">
                            <br>
                             <input type="hidden" name="cin_client" value="<c:out value="${value.cin}"/>" />  
                            
                            <input type="submit" value="Rechercher">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="text-center">
        <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modaladdform">Ajouter une
            Reservation</a>
    </div>
                        </td>
                        <td>
                            <div class="test_cont">
                                <div class="modal fade modalmodifier${i.count}" tabindex="-1" role="dialog"
                                    aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header text-center">
                                                <h4 class="modal-title w-100 font-weight-bold" style="color:black;">
                                                    Remplir les Formules</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                    aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body mx-1">
                                                <form class="form-validate" method="post"
                                                    action="gestion_clientslocal">
                                                    <div class="form-group container-add modalito">
                                                        <label for="nom"><b>Nom</b></label>
                                                        <input type="text" placeholder="Entrer Un Nom" name="nom"
                                                           value="${value.nom}">

                                                        <label for="prenom"><b>Prenom</b></label>
                                                        <input type="text" placeholder="Entrer un Prenom"
                                                            name="prenom" value="${value.prenom}">

                                                        <label for="phone"><b>Telephone</b></label>
                                                        <input type="tel" placeholder="Entrer N° telephone"
                                                            name="phone" min="1" value="${value.phone}">

                                                        <label for="email"><b>Email</b></label>
                                                        <input type="text" placeholder="Entrer EMAIL"
                                                            name="email" min="1" value="${value.email}">
                                                        <label for="mdp"><b>Mot de passe</b></label>
                                                        <input type="text" placeholder="Entrer MOT DE PASSE"
                                                            name="mdp" min="1" value="${value.password}">
                                                            <label for="addresse"><b>Addresse</b></label>
                                                        <input type="text" placeholder="Entrer  ADDRESSE"
                                                            name="addr" min="1" value="${value.addresse}">  
                                                         <input type="hidden" name="cin" value="<c:out value="${value.cin}"/>" />  
                                                         <input type="hidden" name="type" value="change" />
                   <div class="clearfix clearfix1">
                                                            <button type="submit"
                                                                class="signupbtn signupbtn1">Modifier</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center">
                                    <a href="" class="no" data-toggle="modal" data-target=".modalmodifier${i.count}">Modifier</a>
                                </div>

                                <div class="modal fade modaldelete${i.count}" tabindex="-1" role="dialog"
                                    aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header text-center">
                                                <h4 class="modal-title w-100 font-weight-bold" style="color:black;">are
                                                    you sure?</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                    aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body mx-1">
                                                <form class="deleteclass form-validate" method="post"
                                                    action="gestion_clientslocal">
                                                    <button class="yes">Supprimer</button>
                                                    <input type="hidden" name="type" value="remove" />
                                                    <input type="hidden" name="cin"
                                                        value="<c:out value="${value.cin}"/>" />
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center">
                                    <a href="" class="yes" data-toggle="modal" data-target=".modaldelete${i.count}">Supprimer</a>
                                </div>
                            </div>
                        </td>
                    </tr>
 </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Remplir les Formules</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-1">
        <form class="form-validate" method="post"
                                                    action="gestion_clientslocal">
                                                    <div class="form-group container-add modalito">
                                                    <label for="cin">CIN :</label>
                                                        <input type="text" name="cin" />
                                                        <label for="nom"><b>Nom</b></label>
                                                        <input type="text" placeholder="Entrer Un Nom" name="nom"
                                                            >

                                                        <label for="prenom"><b>Prenom</b></label>
                                                        <input type="text" placeholder="Entrer un Prenom"
                                                            name="prenom" >

                                                        <label for="phone"><b>Telephone</b></label>
                                                        <input type="tel" placeholder="Entrer N° telephone"
                                                            name="phone" min="1">

                                                        <label for="email"><b>Email</b></label>
                                                        <input type="text" placeholder="Entrer EMAIL"
                                                            name="email" min="1">
                                                        <label for="mdp"><b>Mot de passe</b></label>
                                                        <input type="text" placeholder="Entrer MOT DE PASSE"
                                                            name="mdp" min="1">
                                                            <label for="addresse"><b>Addresse</b></label>
                                                        <input type="text" placeholder="Entrer  ADDRESSE"
                                                            name="add" min="1">
                                                            <input type="hidden" name="type" value="add" />
                                                            <input type="submit" value="enregistrer" />
                                                               </div>
                                                </form>  
      </div>
    </div>
  </div>
</div>
<div class="text-center">
  <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalLoginForm">Ajouter un Employee</a>
</div>
</body>
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/DataTables/datatables.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#example').DataTable();
    });
    table = $('#example').dataTable({
        "language": {
            search: "_INPUT_",
            searchPlaceholder: "Rechercher les Clients...",
            "sLengthMenu": "Afficher _MENU_ Clients",
            "info": "affichage de _START_ à _END_ parmi _TOTAL_ Clients",
            "paginate": {
                "previous": "Précédent",
                "next": "Suivant"
            },
        }
    });
</script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
</html>