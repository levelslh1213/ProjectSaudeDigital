<%-- 
    Document   : fichaIdentificacao
    Created on : 21 de nov. de 2021, 15:00:09
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int idPaciente =0 ;
    if(request.getAttribute("ID_PACIENTE_CADASTRADO") != null){
        idPaciente = (int) request.getAttribute("ID_PACIENTE_CADASTRADO");
    }
%>

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
  
  
  <title>Ficha de Identificação</title>
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

    <section data-bs-version="5.1" class="menu menu2 cid-sJSYoE7XrK" once="menu" id="menu2-12">
    
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
                    </ul>
                </div>
            </div>
        </nav>
    </section>

    <% if(request.getAttribute("ID_PACIENTE_CADASTRADO") == null){%>

    <section data-bs-version="5.1" class="form6 cid-sKd4BOZjtN mt-0" id="form6-a">    
        <div class="container-fluid">
            <div class="mbr-section-head">
                <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                    <strong>CPF do Paciente</strong></h3>
                
            </div>
            <div class="row justify-content-center mt-4">
                <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                    <form action="ServCadastroPaciente" method="POST" class="mbr-form form-with-styler mx-auto" data-form-title="Form Name">
                        <input type="hidden" name="edtTipoCadastro" value="Pesquisa">
                        <div class="dragArea row">
                            <div class="col-lg-12 col-md- col-sm-12 form-group mb-3" data-for="edtCpf">
                                <input type="text" name="edtCpf" placeholder="CPF" data-form-field="edtCpf" class="form-control" value="" id="name-form6-a">
                            </div>
                            <div class="col-auto mbr-section-btn align-center"><button type="submit" class="btn btn-secondary display-4">Pesquisar<br></button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <%}%>
<section data-bs-version="5.1" class="form5 cid-sKlPf2cqC1" id="form5-14">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Ficha Identificação</strong>
            </h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form action="ServCadastroPaciente" method="POST" class="mbr-form form-with-styler" data-form-title="Form Name">
                    <input type="hidden" name="edtTipoCadastro" value="Ficha">
                    <input type="hidden" name="edtIdPaciente" value="<%=idPaciente%>">
                    <div class="dragArea row">
                        
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtPeso">
                            <input type="text" name="edtPeso" placeholder="Peso" data-form-field="edtPeso" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtAltura">
                            <input type="text" name="edtAltura" placeholder="Altura" data-form-field="edtAltura" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="cmbCor">
                            <select name="cmbCor" class="form-control" id="name-form5-14" data-form-field="cmbCor">
                                <option value="BR">Branco</option>
                                <option value="PR">Preto</option>
                                <option value="PA">Pardo</option>
                                <option value="AM">Amarelo</option>
                                <option value="IN">Índigena</option>
                            </select>
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="cmbEstadoCivil">
                            <select name="cmbEstadoCivil" class="form-control" id="name-form5-14" data-form-field="cmbEstadoCivil">
                                <option value="SO">Solteiro(a)</option>
                                <option value="CA">Casado(a)</option>
                                <option value="SE">Separado(a)</option>
                                <option value="DI">Divorciado(a)</option>
                                <option value="VI">Viúvo(a)</option>
                            </select>
                        </div>
                        <div class="col-12 form-group mb-3" data-for="cmbEscolaridade">
                            <select name="cmbEscolaridade" class="form-control" id="name-form5-14" data-form-field="cmbEscolaridade">
                                <option value="Analfabeto">Analfabeto</option>
                                <option value="Educação Infantil incompleta">Educação Infantil incompleta</option>
                                <option value="Educação Infantil completa">Educação Infantil completa</option>
                                <option value="Ensino fundamental incompleto">Ensino fundamental incompleto</option>
                                <option value="Ensino fundamental completo">Ensino fundamental completo</option>
                                <option value="Ensino médio incompleto">Ensino médio incompleto</option>
                                <option value="Ensino médio completo">Ensino médio completo</option>
                                <option value="Ensino superior incompleto">Ensino superior incompleto</option>
                                <option value="Ensino superior completo">Ensino superior completo</option>
                            </select>
                        </div>
                        
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtNaturalidade">
                            <input type="text" name="edtNaturalidade" placeholder="Naturalidade" data-form-field="edtNaturalidade" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtEstado">
                            <input type="text" name="edtEstado" placeholder="Estado" data-form-field="edtEstado" class="form-control" value="" id="name-form5-14">
                        </div>

                        <br><br><br>

                        <div class="mbr-section-head mb-3 mt-3">
                            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                                <strong>Endereço</strong>
                            </h3>
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtRua">
                            <input type="text" name="edtRua" placeholder="Rua" data-form-field="edtRua" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtBairro">
                            <input type="text" name="edtBairro" placeholder="Bairro" data-form-field="edtBairro" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtComplemento">
                            <input type="text" name="edtComplemento" placeholder="Complemento" data-form-field="edtComplemento" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="ededtNumerotRg">
                            <input type="text" name="edtNumero" placeholder="Número" data-form-field="edtNumero" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCep">
                            <input type="text" name="edtCep" placeholder="CEP" data-form-field="edtCep" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCidade">
                            <input type="text" name="edtCidade" placeholder="Cidade" data-form-field="edtCidade" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtEstado">
                            <input type="text" name="edtEstado" placeholder="Estado" data-form-field="edtEstado" class="form-control" value="" id="name-form5-14">
                        </div>

                        <!--
                        <div class="col-12 form-group mb-3" data-for="textarea">
                            <textarea name="textarea" placeholder="Message" data-form-field="textarea" class="form-control" id="textarea-form5-14"></textarea>
                        </div>
                        -->
                        <div class="col-lg-12 col-md-12 col-sm-12 align-center mbr-section-btn mt-5">
                            <button type="submit" class="btn btn-primary display-4">Enviar</button>
                        </div>
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
