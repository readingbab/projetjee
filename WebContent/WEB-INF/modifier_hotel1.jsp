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
    <div class="card-body">
        <div class="table-responsive">
            <table style="width:100%" id="example" class="table table-bordered table-hover nowrap ">
                <thead class="bg-primary">
                    <tr>
                        <th scope="col" style="width:15%;color: black;">id</th>
                        <th scope="col" style="width:15%;color: black;">ville</th>
                        
                        <th scope="col" style="width:15%;color: black;">Adresse </th>
                        <th scope="col" style="width:15%;color: black;">nom </th>
                        <th scope="col" style="width:15%;color: black;">nombre de chambres</th>
                        <th scope="col" style="width:10%;color: black;">nombre d'étoiles</th>

                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${receptionniste}" var="value" varStatus="i">
                    <tr>
                        <td><c:out value="${value.id}"/></td>
                        <td><c:out value="${value.ville}"/></td>
                         <td><c:out value="${value.adresse}"/></td>
                        <td><c:out value="${value.nom}"/></td>
                        <td><c:out value="${value.nombre_chambre}"/></td>
                        <td><c:out value="${value.nombre_etoile}"/></td>
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
                                                    action="Modifier_hotel">
                                                    <div class="form-group container-add modalito">
                                                        <label for="nom"><b>nom</b></label>
                                                        <input type="text" placeholder="Entrer Un Nom" name="nom"
                                                            required>


                                                        <label for="nombre_chambre"><b>nombre_chambre</b></label>
                                                        <input type="tel" placeholder="Entrer nombre chambre"
                                                            name="nombre_chambre" min="1">

                                                        <label for="nombre_etoile"><b>nombre_etoile</b></label>
                                                        <input type="text" placeholder="Entrer nombre etoile"
                                                            name="nombre_etoile" min="1">
                                                        
                                                         <input type="hidden" name="id" value="<c:out value="${value.id}"/>" />  
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

                                <div class="modal fade modaldelete" tabindex="-1" role="dialog"
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
                                                    action="database_manipulation.php">
                                                    <button class="yes">Supprimer</button>
                                                    <input type="hidden" name="type" value="remove" />
                                                    <input type="hidden" name="numSum"
                                                        value="';echo($donne['num_somme']);echo'" />
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
<script src="${pageContext.request.contextPath}/hotel.js"></script>
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