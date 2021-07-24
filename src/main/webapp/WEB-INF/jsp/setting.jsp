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
    <link href="../../css/account.css" rel="stylesheet" type="text/css">
    <link href="../../css/settings.css" rel="stylesheet" type="text/css">

    <!-- Optional JavaScript -->
    <script defer src="../../js/setting.js"></script>
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <!--Navbar Section-->
    <nav class="navbar">

        <div class="nav_container" id="nav">
            <a href="/" class="nav_logo" id="logo">GAME CENTER</a>

            <div class="nav_toggle" id="menu_button">
                <span class="bar"></span>
                <span class="bar"></span>
                <span class="bar"></span>
            </div>
        </div>


        <ul class="nav_menu">
            <c:if test="${usernamelogged==null}">
                <li class="nav_btn" >
                    <a href="goToLogin" class="button">Login</a>
                </li>
                <li class="nav_btn">
                    <a href="goToRegistrazione" class="button">Registrati</a>
                </li>
            </c:if>
            <c:if test="${usernamelogged!=null}">

                <li class="nav_btn">
                    <a href="doAccount" class="button">Account</a>
                </li>
                <li class="nav_btn">
                    <a href="doLogout"  class="button">Logout</a>
                </li>

            </c:if>

        </ul>


        </div>
    </nav> 
    
    <!--Main Section-->
    <div class="main">
        <!--Image Section-->
        <div class="img_container">
            <img src="../../images/logo.PNG" alt="pic" id="immagine">
        </div>
    </div>
    <div class="container2" id= "segno"> Impostazioni <i class="fas fa-tools fa-lg" id = "icona_impo"></i> </div>
    <div class="container2" id = "main">
        <div class="container" id="dati">
            <ul id = "dati">
                <li id = "dato">
                    Username : 
                </li>
                <li id = "dato">
                    Password :
                </li>
                <li id = "dato">
                    Conferma Password :
                </li>
                <li id = "dato">
                    Email :
                </li>
                <li id = "dato">
					Nome :
                </li>
                <li id = "dato">
                    Cognome :
                </li>
            </ul>
        </div>
        <div class="container" id="risultati">
            <div class="input">
                <input class="campo_risultato" type="text" placeholder="Username" name="username" value="" id="username">
            </div>
            <div class="input">
                <input class="campo_risultato" type="password" placeholder="Password" name="username" value="" id="password">
            </div>
            <div class="input">
                <input class="campo_risultato" type="password" placeholder="Conferma Password" name="username" value="" id="confermaPassword">
            </div>
            <div class="input">
                <input class="campo_risultato" type="email" placeholder="Email" name="username" value="" id="email" >
            </div>
            <div class="input">
                <input class="campo_risultato" type="text" placeholder="Nome" name="username" value="" id="nome" disabled="disabled">
            </div>
            <div class="input">
                <input class="campo_risultato" type="text" placeholder="Cognome" name="username" value="" id="cognome" disabled="disabled">
            </div>
            <div class="button"  id="save">Salva</div>
        </div>
    </div>
</body>
</html>