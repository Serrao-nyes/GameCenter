function doRegistrazione(){
    var button=document.getElementById("signup-form")
	button.addEventListener("submit", function(event){
		event.preventDefault()
		request()
	})
}

function request(){
    var us=document.getElementById("user").value
    var ps=document.getElementById("psw").value
	var em=document.getElementById("email").value
	var nom=document.getElementById("nome").value
	var cogn=document.getElementById("cognome").value
	var regexEmail= /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
	if(!regexEmail.test(em) && em!==""){
		alert("L'email inserita non e' corretta!")
		return
	}
	if(ps.length < 5) {
		alert("La password deve contenere almeno 5 caratteri")
		return
	}
    $.ajax({
        url:"doRegistrazione",
        type:"POST",
        data:{username:us, password:ps, email:em, nome:nom, cognome:cogn},
        success:function (response)
        {
            if (response==="Registrazione effettuata con successo")
            {
				alert("Registrazione effettuata con successo")
                window.location.href="goToLogin"
            }
            else if(response==="Username ed email gia' esistenti")
            {
                alert("Username ed email gia' esistenti")
            }
			else if(response==="Email gia' esistente"){
				alert("Email gia' esistente")
			}
			else{
				alert("Username gia' esistente")
			}
			
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
}
document.onload=doRegistrazione()