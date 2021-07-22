<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title id="titoloPagina"></title>

    <!-- Bootstrap CSS -->
    <link href="../../css/stilecomune.css" rel="stylesheet" type="text/css">
    <link href="../../css/stilegioco.css" rel="stylesheet" type="text/css">
    <link href="../../css/stilehome.css" rel="stylesheet" type="text/css">

    <!-- Optional JavaScript -->
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> type="text/javascript"</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>



<!--Navbar Section-->
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
    <!--Image Section
    <div class="img_container">
        <img src="../images/logo_centergame.png" alt="pic" id="immagine">
    </div>-->

    <div class="Background" id="sfondo" >
        <!--Platforms
    <div class="game_container" id="Platforms">
    </div>-->

        <div class="container" id="sezione_principale">
            <div class="container" id="foto"></div>
            <div class="container" id="info">
                <div  id = "Titolo_gioco"></div>
                <div>
                    <h3>Acquista Qui:</h3>
                    <div class="container" id="sub_info" ></div>
                </div>
                <div >
                    <h3>Categorie:</h3>
                    <div id= categorie>
                    </div>
                </div>
            </div>

        </div>
        <div class="container" id="sezione_secondaria">
            <div class="container" id="video">
                <iframe id= "player"  title="Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
            <div id="galleria"></div>
            <div id="popup">
                <img src="" alt="" id = "immagine-scelto">
            </div>
            <div id="descrizione">
            </div>
        </div>




    </div>
</div>
    <script>

        const Cover=document.getElementById("foto")
        const Titolo=document.getElementById("Titolo_gioco")
        const InfoSec=document.getElementById("sub_info")
        const Categorie=document.getElementById("categorie")
        const sezionesecondaria=document.getElementById("sezione_secondaria")
        const popup = document.getElementById("popup")
        const pop = document.getElementById("immagine-scelto")
        const Video=document.getElementById("player")
        const VideoContainer=document.getElementById("video")
        const Screen=document.getElementById("galleria")
        const Descrizione=document.getElementById("descrizione")
        const Requisti=document.getElementById("requisiti")
        const TitoloPagina=document.getElementById("titoloPagina")
        const indice = [1,2,3,4,5,6]
        var generi
        document.onload=fetchInformation(),fetchVideos(),fetchScreen(),fetchStores()
        //checkRequiremments()

        async function fetchInformation(){
            $.ajax({
                type:'GET',
                url:"https://api.rawg.io/api/games/"+"${idGioco}"+"?key=2d150e2f5c964e6992d048af8ef065f7&",
                success:function (result){
                    createGameInformation(result.background_image,result.name,result.description_raw,result.genres,result.platforms)

                }
            });
        }
        async function fetchVideos(){
            $.ajax({
                type:'GET',
                url:"https://api.rawg.io/api/games/"+"${idGioco}"+"/movies?key=2d150e2f5c964e6992d048af8ef065f7&",
                success:function (result){

                    if( result.count==0){

                        VideoContainer.setAttribute("style","display:none")

                    }
                    else{

                        appendVideo(result.results[0].data.max)
                    }
                }
            });
        }
        async function fetchScreen(){
            $.ajax({
                type:'GET',
                url:"https://api.rawg.io/api/games/"+"${idGioco}"+"/screenshots?key=2d150e2f5c964e6992d048af8ef065f7&",
                success:function (result){

                    appendScreen(result.results)
                }
            });
        }
        async  function fetchStores(){
            $.ajax({
                type:'GET',
                url:"https://api.rawg.io/api/games/"+"${idGioco}"+"/stores?key=2d150e2f5c964e6992d048af8ef065f7&",
                success:function (result){

                    appendStore(result.results)
                }
            });
        }
        function createGameInformation(cover,titolo,descrizione,genres,platform)
        {
            Cover.setAttribute("style","background-image:url("+cover+")")
            Titolo.innerText=titolo
            TitoloPagina.innerText=titolo
            var tit_tes = document.createElement('h1')
            tit_tes.setAttribute ("id", "Tit_tes")
            tit_tes.innerText = "Descrizione"
            Descrizione.append(tit_tes)
            Descrizione.append(descrizione)
            for(var i=0;i<genres.length;i++)
            {
                if(i!=0)
                {generi=generi+genres[i].name+" "}
                else{
                    generi=genres[i].name+" - "
                }
            }
            Categorie.innerText=generi
        }

        function appendVideo(video){
            Video.setAttribute("src",video)
        }


        function myFunction(source){
            popup.style.transform = "translateY(0)"
            pop.setAttribute("src", source)
        }


        function appendScreen(screens){
            var indice = []
            for(var i=0;i<screens.length;i++)
            {
                var screen= document.createElement('img')
                screen.classList.add("immagine")
                Screen.append(screen)
                screen.setAttribute("src",screens[i].image)
                screen.setAttribute("id", i+1)
                screen.setAttribute("onClick", "myFunction(this.src)")
                indice.push(screens[i].image)
            }
        }

        popup.addEventListener('click', ()=>{
            popup.style.transform = "translateY(-100%)"
            pop.src = '';
            pop.alt = '';
        })


        function appendStore(stores){
            for(var i=0;i<stores.length;i++)
            {
                if(stores[i].store_id==1)
                {
                    var steam=document.createElement('a')
                    steam.classList.add("badge")
                    InfoSec.append(steam)
                    steam.setAttribute("style",  "background-image: url('../../images/steam-logo-transparent.png')")
                    steam.setAttribute("href",stores[i].url)

                }
                if(stores[i].store_id==11)
                {
                    var epic =document.createElement('a')
                    epic.classList.add("badge")
                    InfoSec.append(epic)
                    epic.setAttribute("style",  "background-image: url('../../images/epic.png')")
                    epic.setAttribute("href",stores[i].url)
                }
                if(stores[i].store_id==3)
                {
                    var playstation=document.createElement('a')
                    playstation.classList.add("badge")
                    InfoSec.append(playstation)
                    playstation.setAttribute("style",  "background-image: url('../../images/playstation.jpg')")
                    playstation.setAttribute("href",stores[i].url)
                }
                if(stores[i].store_id==2)
                {
                    var xbox=document.createElement('a')
                    xbox.classList.add("badge")
                    InfoSec.append(xbox)
                    xbox.setAttribute("style",  "background-image: url('../../images/xbox.png')")
                    xbox.setAttribute("href",stores[i].url)
                }

                if(stores[i].store_id==5)
                {
                    var gog=document.createElement('a')
                    gog.classList.add("badge")
                    InfoSec.append(gog)
                    gog.setAttribute("style",  "background-image: url('../../images/gog.png')")
                    gog.setAttribute("href",stores[i].url)
                }

                if(stores[i].store_id==6)
                {
                    var nintendo=document.createElement('a')
                    nintendo.classList.add("badge")
                    InfoSec.append(nintendo)
                    nintendo.setAttribute("style", "background-image: url('../../images/nintendo.png')")
                    nintendo.setAttribute("href",stores[i].url)
                }
            }


        }
        /*function checkRequiremments(){

            console.log("chiamo")
            if(Requisti.innerText==="Requisiti:\n Requisiti Minimi: undefined\nRequisiti Consigliati: undefined")
            {
                console.log("entro")
                Requisti.setAttribute("style","display:none")
            }
        }*/
    </script>
</body>
</html>