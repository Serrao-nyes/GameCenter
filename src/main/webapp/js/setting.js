const menu = document.querySelector('#menu_button')
const menulinks = document.querySelector('.nav_menu')
menu.addEventListener('click', function(){
    menu.classList.toggle('is-active')
    menulinks.classList.toggle('active')
})

var button=document.getElementById("save")

button.addEventListener("click", function (){
    request()
})

async function request()
{
        var user=document.getElementById("username").value
        var password=document.getElementById("password").value
        var confPassword=document.getElementById("confermaPassword").value
        var email=document.getElementById("email").value
		var regexEmail= /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

		if(!regexEmail.test(email) && email!==""){
			alert("L'email inserita non e' corretta!")
			return
		}
		if(password !== confPassword) {
			alert("Le due password inserite non coincidono")
			return
		}
		if(password.length < 5 && password!==""){
			alert("La nuova password deve contenere almeno 5 caratteri")
			return
		}
	    $.ajax({
	        url:"doModificheAccount",
	        type:"POST",
	            data:{username:user, password:password, email:email},
	            success:function(response){
	                    if(response==="Modifiche effettuate con successo") {
	                        alert("Modifiche effettuate con successo")
							window.location.href="/"
	                    }
		                else if(response==="Email e username gia' esistenti") {
			                alert("Email e username gia' esistenti")
			            }
						else if(response==="Username gia' esistente") {
							alert("Username gia' esistente")
						}
						else if(response==="Email gia' esistente"){
							alert("Email gia' esistente")
						}
						else {
							alert("La nuova password e' uguale a quella precedente")
						}
	            },
	        	fail: function( jqXHR, textStatus ) {
	            	alert( "Request failed: " + textStatus );
	        	}
	        });
}