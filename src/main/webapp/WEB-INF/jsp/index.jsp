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
    <link href="../css/stilecomune.css" rel="stylesheet" type="text/css">
    <link href="../css/stilehome.css" rel="stylesheet" type="text/css">

    <!-- Optional JavaScript -->
    <script defer src="../js/script.js"></script>
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> type="text/javascript"</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <!--Navbar Section-->
    <nav class="navbar">

        <div class="nav_container" id="nav">
            <a href="index.jsp" class="nav_logo" id="logo">GAME CENTER</a>
            
        <div class="search-bar" id = "ricerca">
	        <input class="input__field" type="search" placeholder="Cerca.." name="cerca" value="">
		    <a class="search-btn"> 
                <i class="fas fa-search"></i>
            </a>
        </div>

            <div class="nav_toggle" id="menu_button">
                <span class="bar"></span>
                <span class="bar"></span>
                <span class="bar"></span>
            </div>
         </div>

        
            <ul class="nav_menu">
                <c:if test="${usernamelogged==null}">
                    <li class="nav_btn" >
                        <a href="goToLogin" class="button">Log In</a>
                    </li>
                    <li class="nav_btn">
                        <a href="goToRegistrazione" class="button">Registrati</a>
                    </li>
                </c:if>
                <c:if test="${usernamelogged!=null}">
                    <li class="nav_item">
                        <a href="#" class="nav_links">Account</a>
                    </li>
                    <li class="nav_item">
                        <a href="#" class="nav_links">Lista Desideri</a>
                    </li>
                    <li class="nav_item">
                        <a href="#" class="nav_links">Libreria</a>
                    </li>
                </c:if>


            </ul>

        </div>
    </nav> 
    
    <!--Main Section-->
    <div class="main">
        <!--Image Section-->
        <div class="img_container">
            <img src="../images/logo.PNG" alt="pic" id="immagine">
        </div>

        <div class="Background" id="sfondo" >
            <!--Platforms-->
        <div class="game_container" id="Platforms">
            <div id="nome"></div>
        </div>

        <!--Game Section-->
        <div class="game_container" id="games">
            
        </div>
        <!--Pulsanti Pagina-->
        <div class="game_container" id="Page_btn"></div>
        </div>

        
        
    </div>
</body>
</html>