function doLogin(){
    var buttonLogin=document.getElementById("login-form")
    buttonLogin.addEventListener("submit",function () {
		event.preventDefault()
		request()
    
    })

}

async function request(){
    var user=document.getElementById("user").value
    var psw=document.getElementById("psw").value
    $.ajax({
        url:"doLogin",
        type:"POST",
        data:{username:user,password:psw},
        success:function (response)
        {
            if (response)
            {
                window.location.href="/"
            }
            else
            {
                alert("Username o Password errati. Riprovare")
                document.getElementById("user").value=""
                document.getElementById("psw").value=""
            }
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
}
document.onload=doLogin()