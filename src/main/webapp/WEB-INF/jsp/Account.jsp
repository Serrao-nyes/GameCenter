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

    <!-- Optional JavaScript -->
    <script defer src="../../js/indexScript.js"></script>
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
                    <li class="nav_btn" >
                        <a href="goToLogin" class="button">Log In</a>
                    </li>
                    <li class="nav_btn">
                        <a href="goToRegistrazione" class="button">Registrati</a>
                    </li>
    </ul>

        </div>
    </nav> 
    
    <!--Main Section-->
<div class="main">
    <!--Image Section-->
    <div class="img_container">
        <img src="../../images/logo.PNG" alt="pic" id="immagine">
    </div>

    <div class="Background" id="sfondo" >

        <div class="container" id="user">
            <div class="name">
                <p id = "nome_utente"> Ciao ${nomeUtente}</p>
            </div>
            <div id="settings">
                <button class="button" id="settaggi"> Settings</button>
            </div>
        </div>
        
        <div class= "container" id ="button-bar">
            <button class="button" id="wishlista">
                wishlist
            </button>
            <button class="button" id="liblista">
                Libreria
            </button>

            </div>
        <div class="game_container" id="games"></div>



        </div>

        </div>
        <script>
            const GameContainer=document.getElementById("games")
            <c:forEach var="gd" items="${giochiDesiderati}">
            async function fetchListaDesideri(){

            }
            </c:forEach>
            function creatGame(name,image,id) {
                var Space = document.createElement('div');
                Space.classList.add("GameSpace");
                Space.className = "GameSpace"
                var Reference = document.createElement('a');
                Reference.setAttribute("href","GamePage?idGioco="+id)
                Space.append(Reference)
                var pulsanti= document.createElement('div')
                pulsanti.classList.add("Btn-container")
                var Img = document.createElement('div')
                Img.classList.add("GameImage")
                Img.style.backgroundImage = "url(" + image + ")"
                var Name = document.createElement('div');
                Name.classList.add("GameName");
                Name.textContent = name
                Reference.append(Img);
                Name.append(pulsanti)
                Space.append(Name);
                var buttonWishlist=document.createElement("i")
                buttonWishlist.setAttribute("class", "fas fa-star fa-lg")
                buttonWishlist.setAttribute("id","wishlist")
                buttonWishlist.setAttribute("href","doGiochiDesiderati")
                buttonWishlist.addEventListener("click",function ()
                {
                    //    console.log(id)
                    if(buttonWishlist.style.backgroundColor==="") {
                        $.ajax({
                            url:"doGiochiDesiderati",
                            type:"POST",
                            data: {idGiocodesiderato : id, nomeGiocoDesiderato : name},
                            success:function (response)
                            {
                                if (response)
                                {
                                    buttonWishlist.setAttribute("style","background-color:green")
                                    alert("Gioco aggiunto alla lista dei desideri")
                                }
                                else
                                {
                                    alert("Devi essere loggato per poter aggiungere un gioco alla lista desideri")
                                }

                            },
                            fail: function( jqXHR, textStatus ) {
                                alert( "Request failed: " + textStatus );
                            }
                        });
                    }
                    else {
                        $.ajax({
                            url:"removeGiochiDesiderati",
                            type:"POST",
                            data: {idGiocoDesiderato : id, nomeGiocoDesiderato : name},
                            success:function (response)
                            {
                                if (response)
                                {
                                    buttonWishlist.setAttribute("style","background-color:")
                                    alert("Gioco eliminato dalla lista dei desideri")
                                }
                                else
                                {
                                    alert("Devi essere loggato per poter eliminare un gioco alla lista desideri")

                                }

                            },
                            fail: function( jqXHR, textStatus ) {
                                alert( "Request failed: " + textStatus );
                            }
                        });
                    }
                })
                var libraryButton=document.createElement("i")
                libraryButton.setAttribute("class", "fas fa-plus-circle fa-lg")
                libraryButton.setAttribute("id", "libreria")
                libraryButton.addEventListener("click",function (){
                    //    console.log(id)
                    if(libraryButton.style.backgroundColor==="") {
                        $.ajax({
                            url:"doGiochiPosseduti",
                            type:"POST",
                            data: {idGiocoPosseduto : id, nomeGiocoPosseduto : name},
                            success:function (response)
                            {
                                console.log(response)
                                if (response)
                                {
                                    libraryButton.setAttribute("style","background-color:green")
                                    alert("Gioco aggiunto alla libreria")
                                }
                                else
                                {
                                    alert("Devi essere loggato per poter aggiungere un gioco alla libreria")
                                }

                            },
                            fail: function( jqXHR, textStatus ) {
                                alert( "Request failed: " + textStatus );
                            }
                        });
                    }
                    else {
                        $.ajax({
                            url:"removeGiochiPosseduti",
                            type:"POST",
                            data: {idGiocoPosseduto : id, nomeGiocoPosseduto : name},
                            success:function (response)
                            {
                                if (response)
                                {
                                    libraryButton.setAttribute("style","background-color:")
                                    alert("Gioco eliminato dalla libreria")
                                }
                                else
                                {
                                    alert("Devi essere loggato per poter eliminare un gioco dalla libreria")

                                }

                            },
                            fail: function( jqXHR, textStatus ) {
                                alert( "Request failed: " + textStatus );
                            }
                        });
                    }

                })
                pulsanti.append(libraryButton)
                pulsanti.append(buttonWishlist)
                GameContainer.append(Space);

            }




        </script>

    </div>
</div>
</body>
</html>