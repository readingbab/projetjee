<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="stylelogin.css">
</head>

<body>
	<script type="text/javascript">
function preback(){window.history.forward();}
setTimeout("preback()",0);
window.onunload=function(){null};
</script>
    <form action="Loginusers" method="POST">
        <div class="login-box">
            <h1>Login</h1>
            <div class="textbox">
                <i class="fas fa-user"></i>
                <input id="email" name="email" type="text" placeholder="Username">
            </div>

            <div class="textbox">
                <i class="fas fa-lock"></i>
                <input id="password" name="password" type="password" placeholder="Password">
            </div>
            <input type="submit" class="btn" value="Login" class="sansLabel" />
        </div>
    </form>
  
    <div class="error"> ${error}</div>
</body>

</html>