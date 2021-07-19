const menu = document.querySelector('#menu_button')
const menulinks = document.querySelector('.nav_menu')
menu.addEventListener('click', function(){
    menu.classList.toggle('is-active')
    menulinks.classList.toggle('active')
})

const GameContainer= document.getElementById('informations')

var PageNumber=1
var PageSize=40
var Store
var Filtred=false
/*document.onload=fetchGames(PageNumber,PageSize,Store),createStoreBadge()

async function fetchGames(page,size,store){
    if(!Filtred)
    { $.ajax({
        type:'GET',
        url:"https://api.rawg.io/api/games?key=2d150e2f5c964e6992d048af8ef065f7&page="+page+"&page_size="+size,
        success:function (result){
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
function creatGame(name,image,id) {
    var Space = document.createElement('div');
    Space.classList.add("GameSpace");
    Space.className = "GameSpace"
    var Reference = document.createElement('a');
    Reference.setAttribute("href","GamePage.html")
    Space.append(Reference)
    var Img = document.createElement('div')
    Img.classList.add("GameImage")
    Img.style.backgroundImage = "url(" + image + ")"
    var Name = document.createElement('div');
    Name.classList.add("GameName");
    Name.textContent = name
    Reference.append(Img);
    Space.append(Name);
    var buttonWishlist=document.createElement("button")
    buttonWishlist.classList.add("wishlist")
    buttonWishlist.setAttribute("id","nyes")
    buttonWishlist.setAttribute("href","doGiochiDesiderati")
    buttonWishlist.addEventListener("click",function ()
    {
        console.log(id)
        $.ajax({
            url:"doGiochiDesiderati",
            type:"POST",
            data: {idGiocodesiderato : id},
            success:function (response)
            {
                if (response)
                {
                    buttonWishlist.setAttribute("style","background-color:green")
                    alert("Gioco aggiunto alla lista dei desideri")
                }
                else
                {
                    alert("Logga per aggiungereun gioco alla lista desideri")
                }

            },
            fail: function( jqXHR, textStatus ) {
                alert( "Request failed: " + textStatus );
            }
        });
    })
    buttonWishlist.addEventListener("mouseenter",function (){
        {buttonWishlist.setAttribute("style","background-color:white")}

    })
    buttonWishlist.addEventListener("mouseleave",function (){

        buttonWishlist.setAttribute("style","background-color:transparent")

    })
    var libraryButton=document.createElement("button")
    libraryButton.classList.add("library")
    libraryButton.addEventListener("mouseenter",function (){
        libraryButton.setAttribute("style","background-color:white")
    })
    libraryButton.addEventListener("mouseleave",function (){
        libraryButton.setAttribute("style","background-color: transparent")})
    Space.append(libraryButton)
    Space.append(buttonWishlist)
    GameContainer.append(Space);

}*/
