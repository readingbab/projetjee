<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Acceuil</title>
    
    
    
    
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet" type="text/css" media="all"/><!--style_sheet-->
<link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,300,400,600,700" rel="stylesheet">
<!--online_fonts-->
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet"><
</head>

<body>
<h1>hotel</h1>
<h1>
		<span style="color:#ff531a">T</span>ravel
		<span style="color:#ff531a">L</span>ogin
		<span style="color:#ff531a">F</span>orm </h1>
<div class="w3ls-main">
<h2>Registration Form</h2>
<p>Complete the form below to sign up for our membership service.</p>
<div class="w3ls-form">
<form action="#" method="post">
<ul class="fields">
<div class="Refer_w3l">
<h3>Your details</h3>
	<li>	
		<label class="w3ls-opt">CIN :<span class="w3ls-star"> * </span></label>
		<div class="w3ls-name">	
			<input type="text" id="cin" name="cin">
		</div>
	</li>
	<li>	
		<label class="w3ls-opt">Nom :<span class="w3ls-star"> * </span></label>
		<div class="w3ls-name">	
		<input type="text" id="nom" name="nom">
		</div>
	</li>
	<li>	
		<label class="w3ls-opt">Prénom :<span class="w3ls-star"> * </span></label>
		<div class="w3ls-name">	
			<input type="text" id="prenom" name="prenom">
		</div>
	</li>
	<li>
		<div class="mail">
			<label class="w3ls-opt">e-mail :<span class="w3ls-star"> * </span></label>
			<span class="w3ls-text w3ls-name">
				<input type="text" id="email" name="email">
			</span>
		</div>
	</li>
	
	<li>
		<label class="w3ls-opt">N° Téléphone :<span class="w3ls-star"> * </span></label>	
			<span class="w3ls-text w3ls-name">
				<input type="text" id="phone" name="phone">
			</span>
	</li>
	<li>
		<label class="w3ls-opt">Address: <span class="w3ls-star"> * </span> </label>
		<div class="adderss">
		<input type="text" id="add" name="add">
		</div>
	</li>
	<li>
		<label class="w3ls-opt">Mot de passe: <span class="w3ls-star"> * </span> </label>
		<div class="adderss">
		<input type="text" id="mdp" name="mdp">
		</div>
	</li>
	<li>
		<label class="w3ls-opt">Confirmer le Mot de passe: <span class="w3ls-star"> * </span> </label>
		<div class="adderss">
		</label><input type="text" id="mdpc"
                        name="mdpc">
		</div>
	</li>
	
						
	</div>
</ul>
<p style="color:red;">${error.mdp}</p>
<p style="color:red;">${error.vide}</p>
<div class="clear"></div>
	<div  >
		<input type="submit" value="Submit Application" >
	</div>
</form>
</div>
</div>
<footer>&copy; 2020 All Rights Reserved </footer>   
 
</body>

</html>