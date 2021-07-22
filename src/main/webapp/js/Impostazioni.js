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