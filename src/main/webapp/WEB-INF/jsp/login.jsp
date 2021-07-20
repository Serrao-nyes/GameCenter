<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game Center</title>

    <!-- Bootstrap CSS -->
    <link href="../../css/stilecomune.css" rel="stylesheet" type="text/css">
    <link href="../../css/stilehome.css" rel="stylesheet" type="text/css">
    <link href="../../css/log-in.css" rel="stylesheet" type="text/css">
    
    <!-- Optional JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> type="text/javascript"</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<c:if test="${usernameLogged != null}">
	<script>
		alert("Username o password erratti. Riprova")
	</script>
</c:if>
<body>
    <!--Navbar Section-->
    <nav class="navbar">
        <div class="nav_container" id="nav">
            <a href="/" class="nav_logo" id="logo">GAME CENTER</a>
        </div>
    </nav>

    <div class="container" id="Log-mod">
        <form id="login-form" method="post" action="doLogin">
            <div class="input">
                <input class="input__field" type="text" placeholder="Username" name="username" value="" id="user">

            </div>
            <div class="input">
                <input class="input__field" type="password" placeholder="Password" name="password" value="" id="psw">
            </div>
            <button class="button button_fill button_medium" type="submit" id="login">Log in</button></form>
            <div class="page__additional">
                <a href="doRegistrazione" rel="nofollow">
                    Don't have an account? Sign up.
                </a>
             <!--   <a href="/password_recovery" rel="nofollow">
                    <span>
                        Forgot your password?
                    </span>
                </a> -->
        </div>
    </div>
</body>