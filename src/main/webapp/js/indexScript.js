const menu = document.querySelector('#menu_button')
const menulinks = document.querySelector('.nav_menu')
menu.addEventListener('click', function(){
    menu.classList.toggle('is-active')
    menulinks.classList.toggle('active')
})

/*const filtro = document.querySelector('.tasto_piattaforma')
filtro.addEventListener('click', function(){
    filtro.classList.toggle('attivo')
})*/

const Posizione = document.getElementById("Page_btn")
var Button_Render = 0;
const GameContainer= document.getElementById('games')
const PlatformContainer=document.getElementById("Platforms")
var PageNumber=1
var PageSize=40
var Store
var Filtred=false
document.onload=fetchGames(PageNumber,PageSize,Store),createStoreBadge(),search()

async function fetchGames(page,size,store){
    Search=false
    if(!Filtred)
    { $.ajax({
            type:'GET',
            url:"https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&page="+page+"&page_size="+size,
            success:function (result){
            Search=false
            for(var i=0;i<result.results.length;i++)
            {
                creatGame(result.results[i].name,result.results[i].background_image,result.results[i].id);
            }
            createButton();

        }
    });}
    else
    {
        $.ajax({
            type:'GET',
            url:"https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&page="+page+"&page_size="+size+"&stores="+store,
            success:function (result){
                for(var i=0;i<result.results.length;i++)
                {
                    creatGame(result.results[i].name,result.results[i].background_image,result.results[i].id);

                }
                createButton();
            }
        });
    }
}

function createStoreBadge()
{
    var steam=document.createElement("div")
    console.log("ciao")
    steam.classList.add("tasto_piattaforma")
    steam.setAttribute("id","steam")
    var sfondos=document.createElement("div")
    sfondos.classList.add("sfondo_piattaforma")
    var nomes=document.createElement("div")
    nomes.classList.add("nome_piattaforma")
    sfondos.setAttribute("style",  "background-image: url('../images/steam-logo-transparent.png')")
    nomes.innerText = "Steam"
    PlatformContainer.append(steam)
    steam.append(sfondos)
    steam.append(nomes)
    steam.addEventListener('click',function () {
        if(Store==1)
        {
            Filtred = false
            Store = 0
            steam.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            fetchGames(1,PageSize,Store)
        }
        else if (Store != 1) {
            Filtred = true
            Store = 1
            steam.setAttribute('style', 'border-color: #e9872b')
            epic.setAttribute('style', 'border-color: #fff')
            xbox.setAttribute('style', 'border-color: #fff')
            gog.setAttribute('style', 'border-color: #fff')
            playstation.setAttribute('style', 'border-color: #fff')
            nintendo.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            if(Search==false)
            {fetchGames(PageNumber, PageSize, Store)}
            else
            { $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&stores="+Store+"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {
                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });}
        }
    })
    var epic=document.createElement("div")
    console.log("ciao")
    epic.classList.add("tasto_piattaforma")
    epic.setAttribute("id","epic")
    var sfondoe=document.createElement("div")
    sfondoe.classList.add("sfondo_piattaforma")
    var nomee=document.createElement("div")
    nomee.classList.add("nome_piattaforma")
    sfondoe.setAttribute("style",  "background-image: url('../images/epic.png')")
    nomee.innerText = "Epic"
    PlatformContainer.append(epic)
    epic.append(sfondoe)
    epic.append(nomee)
    epic.addEventListener('click',function () {
        if(Store==11)
        {
            Filtred = false
            Store = 0
            epic.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            fetchGames(1,PageSize,Store)
        }
        else if (Store != 11) {
            Filtred = true
            Store = 11
            epic.setAttribute('style', 'border-color: #e9872b')
            steam.setAttribute('style', 'border-color: #fff')
            xbox.setAttribute('style', 'border-color: #fff')
            gog.setAttribute('style', 'border-color: #fff')
            playstation.setAttribute('style', 'border-color: #fff')
            nintendo.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            if(Search==false)
            {fetchGames(PageNumber, PageSize, Store)}
            else
            { $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&stores="+Store+"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {
                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });}
        }
    })
    var xbox=document.createElement("div")
    console.log("ciao")
    xbox.classList.add("tasto_piattaforma")
    xbox.setAttribute("id","xbox")
    var sfondox=document.createElement("div")
    sfondox.classList.add("sfondo_piattaforma")
    var nomex=document.createElement("div")
    nomex.classList.add("nome_piattaforma")
    sfondox.setAttribute("style",  "background-image: url('../images/xbox.png')")
    nomex.innerText = "Xbox"
    PlatformContainer.append(xbox)
    xbox.append(sfondox)
    xbox.append(nomex)
    xbox.addEventListener('click',function () {
        if(Store==7)
        {
            Filtred = false
            Store = 0
            xbox.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            fetchGames(1,PageSize,Store)
        }
        else if (Store != 2) {
            Filtred = true
            Store = 2
            xbox.setAttribute('style', 'border-color: #e9872b')
            epic.setAttribute('style', 'border-color: #fff')
            steam.setAttribute('style', 'border-color: #fff')
            gog.setAttribute('style', 'border-color: #fff')
            playstation.setAttribute('style', 'border-color: #fff')
            nintendo.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            if(Search==false)
            {fetchGames(PageNumber, PageSize, Store)}
            else
            { $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&stores="+Store+"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {

                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });}
        }
    })
    var gog=document.createElement("div")
    console.log("ciao")
    gog.classList.add("tasto_piattaforma")
    gog.setAttribute("id","gog")
    var sfondog=document.createElement("div")
    sfondog.classList.add("sfondo_piattaforma")
    var nomeg=document.createElement("div")
    nomeg.classList.add("nome_piattaforma")
    sfondog.setAttribute("style",  "background-image: url('../images/gog.png')")
    nomeg.innerText = "Gog"
    PlatformContainer.append(gog)
    gog.append(sfondog)
    gog.append(nomeg)
    gog.addEventListener('click',function () {
        if(Store==5)
        {
            Filtred = false
            Store = 0
            gog.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            fetchGames(1,PageSize,Store)
        }
        else if (Store != 5) {
            Filtred = true
            Store = 5
            gog.setAttribute('style', 'border-color: #e9872b')
            epic.setAttribute('style', 'border-color: #fff')
            steam.setAttribute('style', 'border-color: #fff')
            xbox.setAttribute('style', 'border-color: #fff')
            playstation.setAttribute('style', 'border-color: #fff')
            nintendo.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            if(Search==false)
            {fetchGames(PageNumber, PageSize, Store)}
            else
            { $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&stores="+Store+"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {
                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });}
        }
    })
    var playstation=document.createElement("div")
    console.log("ciao")
    playstation.classList.add("tasto_piattaforma")
    playstation.setAttribute("id","playstation")
    var sfondop=document.createElement("div")
    sfondop.classList.add("sfondo_piattaforma")
    var nomep=document.createElement("div")
    nomep.classList.add("nome_piattaforma")
    sfondop.setAttribute("style",  "background-image: url('../images/playstation.jpg')")
    nomep.innerText = "PSstore"
    PlatformContainer.append(playstation)
    playstation.append(sfondop)
    playstation.append(nomep)
    playstation.addEventListener('click',function () {
        if(Store==3)
        {
            Filtred = false
            Store = 0
            playstation.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            fetchGames(1,PageSize,Store)
        }
        else if (Store != 3) {
            Filtred = true
            Store = 3
            playstation.setAttribute('style', 'border-color: #e9872b')
            epic.setAttribute('style', 'border-color: #fff')
            steam.setAttribute('style', 'border-color: #fff')
            xbox.setAttribute('style', 'border-color: #fff')
            gog.setAttribute('style', 'border-color: #fff')
            nintendo.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            if(Search==false)
            {fetchGames(PageNumber, PageSize, Store)}
            else
            { $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&stores="+Store+"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {
                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });}
        }
    })

    var nintendo=document.createElement("div")
    console.log("ciao")
    nintendo.classList.add("tasto_piattaforma")
    nintendo.setAttribute("id","nintendo")
    var sfondon=document.createElement("div")
    sfondon.classList.add("sfondo_piattaforma")
    var nomen=document.createElement("div")
    nomen.classList.add("nome_piattaforma")
    sfondon.setAttribute("style",  "background-image: url('../images/nintendo.png')")
    nomen.innerText = "Nintendo"
    PlatformContainer.append(nintendo)
    nintendo.append(sfondon)
    nintendo.append(nomen)
    nintendo.addEventListener('click', function () {
        if(Store==6)
        {
            Filtred = false
            Store = 0
            nintendo.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            fetchGames(1,PageSize,Store)
        }
        else if (Store != 6) {
            Filtred = true
            Store = 6
            nintendo.setAttribute('style', 'border-color: #e9872b')
            epic.setAttribute('style', 'border-color: #fff')
            steam.setAttribute('style', 'border-color: #fff')
            xbox.setAttribute('style', 'border-color: #fff')
            gog.setAttribute('style', 'border-color: #fff')
            playstation.setAttribute('style', 'border-color: #fff')
            cleanGameContainer()
            cleanPosizione()
            if(Search==false)
            {fetchGames(PageNumber, PageSize, Store)}
            else
            { $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&stores="+Store+"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {
                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });}
        }
    })
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
    var buttonWishlist=document.createElement("i")
    buttonWishlist.setAttribute("class", "fas fa-star fa-lg")
    buttonWishlist.setAttribute("id","wishlist")
    //buttonWishlist.setAttribute("href","doGiochiDesiderati")
    buttonWishlist.addEventListener("click",function ()
    {
        //    console.log(id)
        if(buttonWishlist.style.backgroundColor==="") {
            $.ajax({
                url:"doGiochiDesiderati",
                type:"POST",
                data: {idGiocoDesiderato : id, nomeGiocoDesiderato : name},
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
function  createButton()
{
    
    var BackwardButton=document.createElement('button')
    BackwardButton.classList.add("page_button")
    BackwardButton.textContent="<<"
    Posizione.append(BackwardButton)
    var CurrentPage=document.createElement("button")
    CurrentPage.classList.add("page_button")
    CurrentPage.textContent=PageNumber.toString()
    Posizione.append(CurrentPage)
    var FarwardButton=document.createElement('button')
    FarwardButton.classList.add("page_button")
    FarwardButton.setAttribute("id","bottone")
    FarwardButton.textContent=">>"
    Posizione.append(FarwardButton)
    FarwardButton.addEventListener("click",changePageForward)
    BackwardButton.addEventListener("click",changePageBackward)
    Button_Render = 0;
}
function cleanGameContainer()
{
    while (GameContainer.firstChild) {
        GameContainer.removeChild(GameContainer.firstChild);
    }
}

function cleanPosizione()
{
    while (Posizione.firstChild) {
        Posizione.removeChild(Posizione.firstChild)
    }
}


function changePageForward()
{
    cleanGameContainer()
    cleanPosizione()
    PageNumber++
    fetchGames(PageNumber,PageSize,Store)
}
function changePageBackward()
{
    if(PageNumber!=1)
    {
        cleanGameContainer()
        cleanPosizione()
        PageNumber--
        fetchGames(PageNumber,PageSize,Store)
    }
}

function search() {
    var searchutton = document.getElementById("sb")
    searchutton.addEventListener("click", function () {
        Search=true
        Filtred=false
        Store=null
        $.ajax({
            type: 'GET',
            url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&page_size=100",
            success: function (result) {
                cleanGameContainer()
                for (var i = 0; i < result.results.length; i++) {

                    creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                }
                cleanPosizione()
            }
        });

    })
    document.addEventListener("keyup",function (event){
        if(event.keyCode===13)
        {
            Search=true
            Filtred=false
            Store=null
            $.ajax({
                type: 'GET',
                url: "https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&search=" + document.getElementById("cerca").value +"&page_size=100",
                success: function (result) {
                    cleanGameContainer()
                    for (var i = 0; i < result.results.length; i++) {

                        creatGame(result.results[i].name, result.results[i].background_image, result.results[i].id);
                    }
                    cleanPosizione()
                }
            });
        }
    })
}

