<%-- 
    Document   : cadastroProfissional
    Created on : 11 de nov. de 2021, 20:21:41
    Author     : paulo
--%>

<%@page import="Utilitarios.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html  >
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.4.1, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/broken-tooth-96x96.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>CadastroProfissional</title>
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

<section data-bs-version="5.1" class="form5 cid-sKlPf2cqC1" id="form5-14">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Dados do Profissional</strong>
            </h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form action="ServProfissional" method="POST" class="mbr-form form-with-styler">
                        <input type="hidden" name="edtTipoProfissional" value="<%=request.getParameter("Tipo_Prof")%>">
                    <div class="dragArea row">
                        
                        <div class="col-12 form-group mb-3" data-for="edtNome">
                            <input type="text" name="edtNome" placeholder="Nome" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCpf">
                            <input type="text" name="edtCpf" placeholder="CPF"class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtRg">
                            <input type="text" name="edtRg" placeholder="RG" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtDataNasc">
                            <input type="text" name="edtDataNasc" placeholder="Data de Nascimento" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="cmbSexo">
                            <select name="cmbSexo" class="form-control" id="name-form5-14">
                                <option value="M">Masculino</option>
                                <option value="F">Feminino</option>
                            </select>
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtEmail">
                            <input type="text" name="edtEmail" placeholder="Email" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtTelefone">
                            <input type="text" name="edtTelefone" placeholder="Telefone" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCro">
                            <input type="text" name="edtCro" placeholder="CRO" class="form-control" value="" id="name-form5-14">
                        </div>
                        <%
                        if(request.getParameter("Tipo_Prof").equals("S")){
                           %>
                           
                        <div class="col-12 form-group mb-3" data-for="cmbDisciplina">
                            <select name="cmbDisciplina" class="form-control" id="name-form5-14">
                           <%
                               Disciplina disciplina = new Disciplina();
                               int valor =0;
                               String descricao= "";
                               while(disciplina.disciplinas.next()){
                                    valor = disciplina.disciplinas.getInt("ID_DISCIPLINA");
                                    descricao = disciplina.disciplinas.getString("DESCRICAO");
                           %>
                                <option value="<%=valor%>"><%=descricao%></option>
                           <%
                               }
                           %>
                            </select>
                        </div>
                       <% } %>
                        <br><br><br>

                        <div class="mbr-section-head mb-3 mt-3">
                            <h4 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                                <strong>Endereço</strong>
                            </h4>
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtRua">
                            <input type="text" name="edtRua" placeholder="Rua" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtBairro">
                            <input type="text" name="edtBairro" placeholder="Bairro" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtComplemento">
                            <input type="text" name="edtComplemento" placeholder="Complemento" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="ededtNumerotRg">
                            <input type="text" name="edtNumero" placeholder="Número" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCep">
                            <input type="text" name="edtCep" placeholder="CEP" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCidade">
                            <input type="text" name="edtCidade" placeholder="Cidade" data-form-field="edtCidade" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtEstado">
                            <input type="text" name="edtEstado" placeholder="Estado" class="form-control" value="" id="name-form5-14">
                        </div>

                        <!--
                        <div class="col-12 form-group mb-3" data-for="textarea">
                            <textarea name="textarea" placeholder="Message" data-form-field="textarea" class="form-control" id="textarea-form5-14"></textarea>
                        </div>
                        -->
                        <div class="col-lg-12 col-md-12 col-sm-12 align-center mbr-section-btn mt-5">
                            <button type="submit" class="btn btn-primary display-4">Cadastrar</button>
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
</html>s
