<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <style>
        textarea {
            border: none;
            background: whitesmoke;
        }
    </style>
<c:if test="${existe}">
<c:set var="count" value="0" scope="page" />
<c:forEach items="${reclamations}" var="r" varStatus="i">
<form action="Rate?id_reclamation=${r.id_reclamation}" method="post" class="myform">
        <p>type de recelemation: ${r.type}</p>
        <textarea name="text" id="text" cols="30" rows="10" disabled>${r.text}</textarea>
        <input type="hidden" name="type" value="change_reclamation" disabled />
        <input type="submit" value="enregistrer" disabled />
        <button type="button" class="free">modifier</button>
    </form>
    <form action="Rate?id_reclamation=${r.id_reclamation}" method="post" class="myform">
    <input type="hidden" name="type" value="cancel_reclamation"  />
        <input type="submit" value="annuler" />
     </form>
</c:forEach>
</c:if>
<form action="Rate?id=${param.id}" method="post">
<select name="type_reclamation">
  <option value="chambre">Chambre</option>
  <option value="service">Service</option>
  <option value="reservation">reservation</option>
</select>
<textarea name="text" rows="4" cols="50">

</textarea>
<input type="hidden" name="type" value="reclamation"/>
<input type="submit" value="enregistrer"/>
</form>
</body>
<script>
var forms = document.querySelectorAll(".myform");
for (var i = 0, len = forms.length; i < len; i++) {
    var free = forms[i].querySelector(".free");
    free.addEventListener("click", function (e) {
        var form = e.target.parentNode;
        form.querySelector("textarea").style.border = "1px solid black";
        form.querySelector("textarea").style.bockground = "white";
        e.target.outerHTML = "";
        var myselect = document.createElement("SELECT");
        var option = document.createElement("option");
        option.text = "Chambre";
        myselect.add(option);
        option = document.createElement("option");
        option.text = "service";
        myselect.add(option);
        option = document.createElement("option");
        option.text = "reservation";
        myselect.add(option);
        myselect.setAttribute("name", "type_reclamation");
        form.insertBefore(myselect, form.firstChild);
        for (var child = form.firstChild; child !== null; child = child.nextSibling) {
            child.disabled = false;

        }
    });
}

</script>
</html>