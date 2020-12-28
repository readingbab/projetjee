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
<title>Modifier employee</title>
</head>
<body>
<form method="post" action="Loginusers">
 <input type="hidden" name="deconnecterlocal" value="deconnecterlocal" />
  <input type="submit" value="déconnecter"/>
</form>
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
                        <th scope="col" style="width:10%;color: black;">MOT DE PASSE</th>
                        <th scope="col" style="width:30%;color: black;">Adresse</th>
                        <th scope="col" style="width:30%;color: black;">Ville</th>
                        <th scope="col" style="width:30%;color: black;">Hotel</th>
                        <th scope="col" style="width:30%;color: black;">parametre</th>

                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${receptionniste}" var="value" varStatus="i">
                    <tr>
                        <td><c:out value="${value.cin}"/></td>
                        <td><c:out value="${value.nom}"/></td>
                        <td><c:out value="${value.prenom}"/></td>
                        <td><c:out value="${value.telephone}"/></td>
                        <td><c:out value="${value.email}"/></td>
                        <td><c:out value="${value.mot_passe}"/></td>
                        <td><c:out value="${value.addresse}"/></td>
                        <td><c:out value="${value.ville_hotel}"/></td>
                        <td><c:out value="${value.nom_hotel}"/></td>
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
                                                    action="Modifier_employe">
                                                    <div class="form-group container-add modalito">
                                                        <label for="nom"><b>Nom</b></label>
                                                        <input type="text" placeholder="Entrer Un Nom" name="nom"
                                                            value="${value.nom}">

                                                        <label for="prenom"><b>Prenom</b></label>
                                                        <input type="text" placeholder="Entrer un Prenom"
                                                            name="prenom" value="${value.prenom}">

                                                        <label for="phone"><b>Telephone</b></label>
                                                        <input type="tel" placeholder="Entrer N° telephone"
                                                            name="phone" min="1" value="${value.telephone}">

                                                        <label for="email"><b>Email</b></label>
                                                        <input type="text" placeholder="Entrer EMAIL"
                                                            name="email" min="1" value="${value.email}">
                                                        <label for="mdp"><b>Mot de passe</b></label>
                                                        <input type="text" placeholder="Entrer MOT DE PASSE"
                                                            name="mdp" min="1" value="${value.mot_passe}">
                                                            <label for="addresse"><b>Addresse</b></label>
                                                        <input type="text" placeholder="Entrer  ADDRESSE"
                                                            name="addresse" min="1" value="${value.addresse}">  
                                                         <input type="hidden" name="cin" value="<c:out value="${value.cin}"/>" />  
                                                         <input type="hidden" name="type" value="change" />
                                                                        <label for="ville">VILLE</label>
                <select id="ville" name="ville" class="used ville">
                    <c:forEach var="villehotel" items="${VilleHotel}">
                    <c:choose>
                          <c:when test="${villehotel.key == value.ville_hotel}">
                          <option value="${villehotel.key}" selected="selected">${villehotel.key}</option>
                           </c:when>
                            <c:otherwise>
                           <option value="${villehotel.key}" >${villehotel.key}</option>
                            </c:otherwise>
                                  </c:choose> 
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
                    <c:if test="${villehotel.key == value.ville_hotel}">
                       <select  class="newSel used" id="newSel used" name="hotel">
                       <c:forEach items="${villehotel.value}" var="hotels" varStatus="_status1" > 
                        <c:choose>
                          <c:when test="${hotels==value.nom_hotel}">
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
                                                    action="Modifier_employe">
                                                    <input type="hidden" name="type" value="remove" />
                                                    <input type="hidden" name="cin" value="<c:out value="${value.cin}"/>" />
                                               <center>  <button class="yes">Supprimer</button></center>
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
                                                    action="Modifier_employe">
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
                                                            name="telephone" min="1">

                                                        <label for="email"><b>Email</b></label>
                                                        <input type="text" placeholder="Entrer EMAIL"
                                                            name="email" min="1">
                                                        <label for="mdp"><b>Mot de passe</b></label>
                                                        <input type="text" placeholder="Entrer MOT DE PASSE"
                                                            name="mot_passe" min="1">
                                                            <label for="addresse"><b>Addresse</b></label>
                                                        <input type="text" placeholder="Entrer  ADDRESSE"
                                                            name="addresse" min="1">
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
            searchPlaceholder: "Rechercher les employées...",
            "sLengthMenu": "Afficher _MENU_ employée",
            "info": "affichage de _START_ à _END_ parmi _TOTAL_ employée",
            "paginate": {
                "previous": "Précédent",
                "next": "Suivant"
            },
        }
    });
</script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<script >
var oldSel;
document.querySelectorAll('.ville').forEach(item => {
	  item.addEventListener('change', function (e) {
		    oldSel = item.nextElementSibling;
		    while (oldSel.className != "newSel used" || oldSel.tagName=== 'LABEL') {
		        oldSel = oldSel.nextElementSibling;
		    }
		    console.log();
		    console.log(oldSel);
		    while (oldSel.options.length > 0) {
		        oldSel.remove(oldSel.options.length - 1);
		    }
		    var valeur = item.value;
		    console.log(valeur);
		    var newSel = $('.' + valeur).get(0);

		    for (i = 0; i < newSel.length; i++) {
		        var opt = document.createElement('option');

		        opt.text = newSel.options[i].text;
		        opt.value = newSel.options[i].value;

		        oldSel.add(opt, null);
		    }
		});

	  });


</script>
</html>