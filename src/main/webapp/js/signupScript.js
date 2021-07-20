function doRegistrazione(){
    document.getElementById("reg").addEventListener("click",function (){
        if (document.getElementById("user").value==="" || document.getElementById("psw").value===""
            || document.getElementById("email").value===""
            || document.getElementById("nome").value==="" || document.getElementById("cognome").value==="" )
        {alert("Compila tutti i campi")}
        else{request()}
    })
    document.addEventListener("keyup",function (event){
        if(event.keyCode===13)
        {
            if (document.getElementById("user").value==="" || document.getElementById("psw").value===""
                || document.getElementById("email").value===""
                || document.getElementById("nome").value==="" || document.getElementById("cognome").value==="" )
            {alert("Compila tutti i campi")}
            else{request()}
        }
    })
}




function request(){
    var user=document.getElementById("user").value
    var psw=document.getElementById("psw").value
    var email=document.getElementById("email").value
    var nome=document.getElementById("nome").value
    var cognome=document.getElementById("cognome").value
    $.ajax({
        url:"doRegistrazione",
        type:"POST",
        data:{username:user,password:psw,email:email,nome:nome,cognome:cognome},
        success:function (response)
        {
            if (response==="Registrazione effettuata con successo")
            {
                window.location.href="/html/login.html"
            }
            else if (response==="Username ed email già esistenti")
            {

                alert("Username ed email già esistenti")

            }
            else if(response==="Username già esistente")
            {
                alert("Username già esistente")
            }
            else
            {
                alert("Email già esistente")
            }
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
}
doRegistrazione()