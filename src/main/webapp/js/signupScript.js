function doRegistrazione() {
	var button = document.getElementById("reg")
    button.addEventListener("click",function (){
			location.href = "doRegistrazione"
			request()
    })
}




function request(){
    var user=document.getElementById("user").value
    var psw=document.getElementById("psw").value
    var email=document.getElementById("email").value
    var nome=document.getElementById("nome").value
    var cognome=document.getElementById("cognome").value
	console.log(user + "JSFUORI")
			console.log(psw + "JSFUORI")
			console.log(email + "JSFUORI")
			console.log(nome + "JSFUORI")
			console.log(cognome + "JSFUORI")
    $.ajax({
        url:"doRegistrazione",
        type:"POST",
        data:{username:user,password:psw,email:email,nome:nome,cognome:cognome},
        success:function (response)
        {
			console.log(user + "JS")
			console.log(psw + "JS")
			console.log(email + "JS")
			console.log(nome + "JS")
			console.log(cognome + "JS")
            if (response==="Registrazione effettuata con successo")
            {
				alert("Registrazione effettuata con successo")
                location.href = "goToLogin"
            }
			else if(response==="Tutti i campi devono essere compilati") {
				
				alert("Tutti i campi devono essere compilati")
                location.href = "goToRegistrazione"
			}
            else if (response==="Username ed email già esistenti")
            {

                alert("Username ed email già esistenti")
                location.href = "goToRegistrazione"
            }
            else if(response==="Username già esistente")
            {
                alert("Username già esistente")
                location.href = "goToRegistrazione"
            }
            else
            {
                alert("Email già esistente")
                location.href = "goToRegistrazione"
            }
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
}
document.onload=doRegistrazione()