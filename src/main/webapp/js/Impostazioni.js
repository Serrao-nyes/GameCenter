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
        var nome=document.getElementById("nome").value
        var cognome=document.getElementById("cognome").value
		var regexEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
		if(!regexEmail.test(email) && !email===""){
			alert("L'email inserita non e' corretta!")
			return
		}
		if(password.length < 5 && !password===""){
			alert("La nuova password deve contenere almeno 5 caratteri")
			return
		}
	    $.ajax({
	        url:"doModificheAccount",
	        type:"POST",
	            data:{username:user, password:password,confermaPassword:confPassword,email:email,nome:nome,cognome:cognome},
	            success:function(response){
	                    if(response==="Modifiche effettuate con successo")
	                    {
	                        alert("Modifiche effettuate con successo")
	                    }
	                    else
	                    {
	                        alert("Le due password inserite non coincidono")
	                    }
	            },
	        	fail: function( jqXHR, textStatus ) {
	            	alert( "Request failed: " + textStatus );
	        	}
	        });
}