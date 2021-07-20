function doRegistrazione(){
    document.getElementById("reg").addEventListener("click",function (){
        if (document.getElementById("user").value==="" || document.getElementById("psw").value===""
            || document.getElementById("email").value===""
            || document.getElementById("nome").value==="" || document.getElementById("cognome").value==="" )
        {alert("Compila tutti i campi")
            window.location.replace("goToRegistrazione")
        }
        else{

            request()
            window.location.replace("doRegistrazione")
        }
    })
    document.addEventListener("keyup",function (event){
        if(event.keyCode===13)
        {
            if (document.getElementById("user").value==="" || document.getElementById("psw").value===""
                || document.getElementById("email").value===""
                || document.getElementById("nome").value==="" || document.getElementById("cognome").value==="" )
            {alert("Compila tutti i campi")
                window.location.replace("goToRegistrazione")
            }
            else{   window.location.replace("doRegistrazione")
                request()}
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

                window.location.replace("goToLogin")
            }
            else if (response==="Username ed email già esistenti")
            {

                alert("Username ed email già esistenti")
                window.location.replace("goToRegistrazione")
            }
            else if(response==="Username già esistente")
            {
                alert("Username già esistente")
                window.location.replace("goToRegistrazione")
            }
            else
            {
                alert("Email già esistente")
                window.location.replace("goToRegistrazione")
            }
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
}
document.onload=doRegistrazione()