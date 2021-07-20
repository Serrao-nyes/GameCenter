<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Game Center</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

  <!-- Bootstrap CSS -->
  <link href="../../css/stilecomune.css" rel="stylesheet" type="text/css">
  <link href="../../css/stilehome.css" rel="stylesheet" type="text/css">
  <link href="../../css/log-in.css" rel="stylesheet" type="text/css">

  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
</head>
<body>
<!--Navbar Section-->
<nav class="navbar">
  <div class="nav_container" id="nav">
    <a href="/" class="nav_logo" id="logo">GAME CENTER</a>
  </div>
</nav>
<c:if test="${errore!=null}">
	<script>
		alert("${errore}")
	</script>
</c:if>
<div class="container" id="Sign-mod">
  <form id="login-form" method="post" action="doRegistrazione">
    <div class="input">
      <input class="input__field" type="text" placeholder="Username" value="" name="username" id="user" required>
    </div>
    <div class="input">
      <input class="input__field" type="password" placeholder="Password" value="" name="password" id="psw"required>
    </div>
    <div class="input">
      <input class="input__field" type="email" placeholder="Email"  value="" name="email" id="email"required>
    </div>
    <div class="input">
      <input class="input__field" type="text" placeholder="Nome" value="" name="nome" id="nome"required>
    </div>
     <div class="input">
      <input class="input__field" type="text" placeholder="Cognome" value="" name="cognome" id="cognome"required>
    </div>
    <button class="button button_fill button_medium" type="submit" id="reg">Registrati</button></form>
  <div class="page__additional_sign">
    Benvenuto in GameCenter!
  </div>
</div>
</body>