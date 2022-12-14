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

<div class="container" id="Sign-mod">
  <form id="login-form" method="post">
    <div class="input">
      <input class="input__field" type="email" placeholder="Email" name="email" value="">
    </div>
    <div class="input">
      <input class="input__field" type="UserName" placeholder="UserName" name="email" value="">
    </div>
    <div class="input">
      <input class="input__field" type="Nome" placeholder="Nome" name="email" value="">
    </div>
    <div class="input">
      <input class="input__field" type="Cognome" placeholder="Cognome" name="email" value="">
    </div>
    <div class="input">
      <input class="input__field" type="password" placeholder="Password" name="password" value="">
    </div>
    <button class="button button_fill button_medium" type="submit">Log in</button></form>
  <div class="page__additional_sign">
    Benvenuto in GameCenter!
  </div>
</div>
</body>