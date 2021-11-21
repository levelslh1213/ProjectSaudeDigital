<%-- 
    Document   : login
    Created on : 8 de nov. de 2021, 20:36:33
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v5.4.1, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.4.1, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/broken-tooth-96x96.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>login</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap"></noscript>
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
  
</head>
<body>
  
<section data-bs-version="5.1" class="menu menu2 cid-sJSYoE7XrK" once="menu" id="menu2-8">
    
    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a href="https://mobiri.se">
                        <img src="assets/images/broken-tooth-96x96.png" alt="Mobirise" style="height: 3rem;">
                    </a>
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-black display-7" href="">Saúde Digital</a></span>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-bs-toggle="collapse" data-target="#navbarSupportedContent" data-bs-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <div class="hamburger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
                    <li class="nav-item">
                        <a class="nav-link link text-black show text-primary display-4" href="index.html" data-bs-auto-close="outside" aria-expanded="true">Página Inicial</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link link dropdown-toggle text-black display-4" href="#" data-toggle="dropdown-submenu" data-bs-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">Cadastre-se</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown-undefined">
                            <a class="dropdown-item text-black display-4" href="cadastroProfissional.html" data-bs-toggle="dropdown" data-bs-auto-close="outside">Profissional</a>
                            <a class="show dropdown-item text-black display-4" href="cadastroProfissional.html" data-bs-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">Supervisor</a>
                        </div>
                    </li>
                </ul>
                
            </div>
        </div>
    </nav>
</section>

<section data-bs-version="5.1" class="form6 cid-sKd4BOZjtN mt-5" id="form6-a">
    
    
    <div class="container-fluid">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Login</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form action="ServLogin" method="POST" class="mbr-form form-with-styler mx-auto" data-form-title="Form Name">
                    <div class="dragArea row">
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="name">
                            <input type="text" name="edtLogin" placeholder="Login" data-form-field="edtLogin" class="form-control" value="" id="name-form6-a">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="email">
                            <input type="text" name="edtSenha" placeholder="Senha" data-form-field="edtSenha" class="form-control" value="" id="email-form6-a">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="cmbTipoLogin">
                            <select name="cmbTipoLogin" class="form-control" id="name-form5-14">
                                <option value="P">Profissional</option>
                                <option value="S">Supervisor</option>
                                <option value="C">Paciente</option>
                            </select>
                        </div>
                        
                        <div class="col-auto mbr-section-btn align-center"><button type="submit" class="btn btn-secondary display-4">Entrar<br></button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>  
<script src="assets/smoothscroll/smooth-scroll.js"></script>  
<script src="assets/ytplayer/index.js"></script>  
<script src="assets/dropdown/js/navbar-dropdown.js"></script>  
<script src="assets/formoid/formoid.min.js"></script>
  
</body>
</html>