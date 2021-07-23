function doRegistrazione(){
    var button=document.getElementById("signup-form")
	button.addEventListener("submit", function(event){
		console.log("riga 5")
		event.preventDefault()
		request()
	})
	/*document.addEventListener("keyup", function (event){
        if(event.keyCode===13)
        {	
			event.preventDefault()
	        request()
        }
    })*/
	

}

function request(){
    var us=document.getElementById("user").value
    var ps=document.getElementById("psw").value
	var em=document.getElementById("email").value
	var nom=document.getElementById("nome").value
	var cogn=document.getElementById("cognome").value
	console.log("request 17")
    $.ajax({
        url:"doRegistrazione",
        type:"POST",
        data:{username:us, password:ps, email:em, nome:nom, cognome:cogn},
        success:function (response)
        {
			console.log("riga 32")
            if (response==="Registrazione effettuata con successo")
            {
				console.log("riga 34")
				alert("Registrazione effettuata con successo")
				console.log("27")
                window.location.href="goToLogin"
            }
            else if(response==="Username ed email gia esistenti")
            {
				console.log("32")
                alert("Username ed email gia esistenti")
            }
			else if(response==="Email gia esistente"){
				alert("Email gia esistente")
			}
			else{
				console.log("39")
				alert("Username gia esistente")
			}
			
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
	console.log("request 48")
}
document.onload=doRegistrazione()