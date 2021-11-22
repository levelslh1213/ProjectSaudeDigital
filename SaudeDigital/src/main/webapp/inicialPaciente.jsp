<%-- 
    Document   : inicialPaciente
    Created on : 21 de nov. de 2021, 18:53:33
    Author     : paulo
--%>


<%@page import="Model.Paciente"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ResultSet result = null;
    
    String nome = "";
    
    Paciente paciente = new Paciente();
    
    int idPaciente =0;
    if(request.getAttribute("ID_PACIENTE") != null){
        idPaciente = (int) request.getAttribute("ID_PACIENTE");
        result = paciente.getPacienteById(idPaciente);
        nome = result.getString("NOME");
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
  
  
  <title>Página Inicial Paciente</title>
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
                    <div class="navbar-buttons mbr-section-btn"><a class="btn btn-secondary display-4" href="page1.html"><%=nome%></a></div>
                </div>
            </div>
        </nav>
    </section>

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
                    <input type="hidden" name="edtTipoCadastro" value="Update">
                    <input type="hidden" name="edtIdPaciente" value="<%=idPaciente%>">
                    <div class="dragArea row">
                        <!--INFORMAÕES DA PESSAO-->
                        <div class="col-12 form-group mb-3" data-for="edtNome">
                            <input type="text" name="edtNome" placeholder="Nome" data-form-field="edtNome" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtCpf">
                            <input type="text" name="edtCpf" placeholder="CPF" data-form-field="edtCpf" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtRg">
                            <input type="text" name="edtRg" placeholder="RG" data-form-field="edtRg" class="form-control" value="" id="email-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtDataNasc">
                            <input type="text" name="edtDataNasc" placeholder="Data de Nascimento" data-form-field="edtDataNasc" class="form-control" value="" id="name-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="cmbSexo">
                            <select name="cmbSexo" class="form-control" id="name-form5-14" data-form-field="cmbSexo">
                                <option value="M">Masculino</option>
                                <option value="F">Feminino</option>
                            </select>
                        </div>
                        <div class="col-12 form-group mb-3" data-for="edtEmail">
                            <input type="text" name="edtEmail" placeholder="Email" data-form-field="edtEmail" class="form-control" value="" id="url-form5-14">
                        </div>
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtTelefone">
                            <input type="text" name="edtTelefone" placeholder="Telefone" data-form-field="edtTelefone" class="form-control" value="" id="email-form5-14">
                        </div>
                        
                        <!--INFORMAÇÕES DO PACIENTE-->
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
                        <!--INFORMAÇÕES DO ENDEREÇO-->
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
                        <div class="col-md-6 col-sm-12 form-group mb-3" data-for="edtNumero">
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

                        <div class="col-lg-12 col-md-12 col-sm-12 align-center mbr-section-btn mt-5">
                            <button type="submit" class="btn btn-primary display-4">Atualizar Informações</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!---------------------------------RESTO DAS INFORMAÇÕES------------------------------------->

<section data-bs-version="5.1" class="info1 cid-sKg7UaInT9" id="info1-j">
    
    
    <div class="align-center container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-8">
                <h3 class="mbr-section-title mb-4 mbr-fonts-style display-2">
                    <strong>Visualizar termo de resposabilidade</strong></h3>
                
                <div class="mbr-section-btn"><a class="btn btn-secondary display-4" href="termoResponsabilidade.html">Gerar termo</a></div>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="features9 cid-sKfU6tyIoF" id="features10-f">
    <!---->
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style mb-0 display-2">
                <strong>Encaminhamentos</strong></h3>
            
        </div>
        <div class="row mt-4">
            <div class="card col-12">
                <div class="card-wrapper">
                    <div class="top-line row">
                        <div class="col">
                            <h4 class="card-title mbr-fonts-style display-5"><strong>Titulo Encaminhamento</strong></h4>
                        </div>
                        <div class="col-auto">
                            <p class="price mbr-fonts-style display-5">Data consulta</p>
                        </div>
                    </div>
                    <div class="bottom-line">
                        <p class="mbr-text mbr-fonts-style display-7">Descricao do encaminhamento, com descricao do procedimento.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer4 cid-sJT1oI5utu" once="footers" id="footer4-c">

    
    
    <div class="container">
        <div class="row mbr-white">
            <div class="col-6 col-lg-3">
                <div class="media-wrap col-md-4 col-12">
                    <a href="https://mobiri.se/">
                        <img src="assets/images/broken-tooth-168x168.png" alt="Mobirise">
                    </a>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7"><strong>Unisagrado</strong></h5>
                <p class="mbr-text mbr-fonts-style mb-4 display-4">
                    Aqui você percorre os caminhos indispensáveis para sua formação como profissional e desenvolve as melhores competências de uma trajetória com um novo jeito de pensar.</p>
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-3 display-7">
                    <strong>Siga-nos</strong></h5>
                <div class="social-row display-7">
                    <div class="soc-item">
                        <a href="https://www.facebook.com/odontounisagrado/" target="_blank">
                            <span class="mbr-iconfont socicon-facebook socicon" style="color: rgb(0, 0, 0); fill: rgb(0, 0, 0);"></span>
                        </a>
                    </div>
                    <div class="soc-item">
                        <a href="https://twitter.com/unisagrado" target="_blank">
                            <span class="mbr-iconfont socicon-twitter socicon"></span>
                        </a>
                    </div>
                    <div class="soc-item">
                        <a href="https://www.instagram.com/odonto_unisagrado/" target="_blank">
                            <span class="mbr-iconfont socicon-instagram socicon"></span>
                        </a>
                    </div>
                    
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7"><strong>Institucional</strong></h5>
                <ul class="list mbr-fonts-style display-4">
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/institucional/quem-somos" class="text-white" target="_blank">Quem somos</a></li>
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/institucional/missao-visao-e-valores" class="text-white" target="_blank">Missão, visão e valores</a></li>
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/institucional/entidade-filantropica" class="text-white text-primary" target="_blank">Entidade Filantrópica</a></li><a href="https://unisagrado.edu.br/institucional/infraestrutura" class="text-primary" target="_blank">
                    </a><li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/institucional/infraestrutura" class="text-white" target="_blank">Infraestrutura</a></li>
                </ul>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7">
                    <strong>Contato</strong></h5>
                <ul class="list mbr-fonts-style display-4">
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/contato/fale-conosco" class="text-white" target="_blank">Fale conosco</a></li>
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/contato/ouvidoria" class="text-white" target="_blank">Ouvidoria</a></li>
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/contato/trabalhe-conosco" class="text-white" target="_blank">Trabalhe Conosco</a></li>
                    <li class="mbr-text item-wrap"><a href="https://unisagrado.edu.br/contato/como-chegar" class="text-white" target="_blank">Como chegar</a></li>
                </ul>
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
