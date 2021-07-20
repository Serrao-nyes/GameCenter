const menu = document.querySelector('#menu_button')
const menulinks = document.querySelector('.nav_menu')
menu.addEventListener('click', function(){
    menu.classList.toggle('is-active')
    menulinks.classList.toggle('active')
})

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
    var steam=document.createElement("button")
    steam.classList.add("badge")
    steam.setAttribute("id","steam")
    PlatformContainer.append(steam)
    steam.setAttribute("style",  "background-image: url('../images/steam-logo-transparent.png')")
    steam.addEventListener('click',function () {
        if (Store != 1) {
            Filtred = true
            Store = 1
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
    var epic=document.createElement("button")
    epic.classList.add("badge")
    epic.setAttribute("id","epic")
    PlatformContainer.append(epic)
    epic.setAttribute("style",  "background-image: url('../images/epic.png')")
    epic.addEventListener('click',function () {
        if (Store != 11) {
            Filtred = true
            Store = 11
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
    var xbox=document.createElement("button")
    xbox.classList.add("badge")
    xbox.setAttribute("id","xbox")
    PlatformContainer.append(xbox)
    xbox.setAttribute("style",  "background-image: url('../images/xbox.png')")
    xbox.addEventListener('click',function () {
        if (Store != 7) {
            Filtred = true
            Store = 7
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
    var gog=document.createElement("button")
    gog.classList.add("badge")
    gog.setAttribute("id","gog")
    PlatformContainer.append(gog)
    gog.setAttribute("style",  "background-image: url('../images/gog.png')")
    gog.addEventListener('click',function () {
        if (Store != 5) {
            Filtred = true
            Store = 5
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
    var playstation=document.createElement("button")
    playstation.classList.add("badge")
    playstation.setAttribute("id","playstation")
    PlatformContainer.append(playstation)
    playstation.setAttribute("style",  "background-image: url('../images/playstation.jpg')")
    playstation.addEventListener('click',function () {
        if (Store != 3) {
            Filtred = true
            Store = 3
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
    var nintendo = document.createElement("button")
    nintendo.classList.add("badge")
    nintendo.setAttribute("id", "nintendo")
    PlatformContainer.append(nintendo)
    nintendo.setAttribute("style", "background-image: url('../images/nintendo.png')")
    nintendo.addEventListener('click', function () {
        if (Store != 6) {
            Filtred = true
            Store = 6
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
    Reference.setAttribute("href","GamePage.html")
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

