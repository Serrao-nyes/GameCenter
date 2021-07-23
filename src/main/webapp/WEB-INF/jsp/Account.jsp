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
    <script defer src="/js/account.js"></script>
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
                    <li class="nav_item" >
                        <div class="nome-nav"> Benvenuto, ${nomeUtente}</div>
                    </li>
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

    <div class="Background" id="sfondo" >

        <div class="container" id="user">
            <div class="name">
                <p id = "nome_utente"> Ciao ${nomeUtente}</p>
            </div>
            <div id="settings">
                <button class="button" onclick="window.location.href='doImpostazioni'" id="settaggi">Impostazioni</button>
            </div>
        </div>
        
        <div class= "container" id ="button-bar">



            </div>
        <div class="game_container" id="games">

            <p id="wishlista">
                Wishlist
            </p>
        </div>
        <div class="game_container" id="games2">

            <p id="liblista">
                Libreria
            </p>

        </div>




        </div>

        </div>


    <c:if test="${giochiDesiderati!=null}">
        <c:forEach var="gd" items="${giochiDesiderati}">
    <script>
        var GameContaine=document.getElementById("games")
        async function fetchListaDesideri(id){
            $.ajax({
                type:'GET',
                url:"https://api.rawg.io/api/games/"+id+"?key=2d150e2f5c964e6992d048af8ef065f7&",
                success:function (result){
                    creatGame(result.name,result.background_image,result.id)
                }
            });
        }



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

            GameContaine.append(Space);

        }

        document.onload=fetchListaDesideri("${gd.id}")
    </script>
        </c:forEach>
    </c:if>
    <c:if test="${giochiDesiderati==null}">

        <script>
            var GameContainer=document.getElementById("games")
            var error=document.createElement("p")
            error.innerText="LA TUA WISHLIST E' VUOTA"
            GameContainer.append(error)
        </script>

    </c:if>
    <c:if test="${giochiPosseduti!=null}">
        <c:forEach var="gd" items="${giochiPosseduti}">
            <script>
                var GameContainer=document.getElementById("games2")
                async function fetchListaDesideri(id){
                    $.ajax({
                        type:'GET',
                        url:"https://api.rawg.io/api/games/"+id+"?key=2d150e2f5c964e6992d048af8ef065f7&",
                        success:function (result){
                            creatGame(result.name,result.background_image,result.id)
                        }
                    });
                }



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
                    GameContainer.append(Space);

                }

                document.onload=fetchListaDesideri("${gd.id}")
            </script>
        </c:forEach>
    </c:if>
    <c:if test="${giochiPosseduti==null}">

        <script>
            var GameContainer=document.getElementById("games2")
            GameContainer.innerText="LA TUA LIBRERIA E' VUOTA"
        </script>

    </c:if>

    </div>
</div>
</body>
</html>