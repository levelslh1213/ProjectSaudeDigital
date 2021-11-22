<%-- 
    Document   : inicialProfissional
    Created on : 21 de nov. de 2021, 01:15:46
    Author     : paulo
--%>

<%@page import="Model.Supervisor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Model.Endereco"%>
<%@page import="Model.Profissional"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ResultSet result = null;
    
    Profissional profissional = new Profissional();
    Supervisor supervisor = new Supervisor();
    Endereco endereco = new Endereco();
    
    int idProfissional = 0;
    int idSupervisor = 0;
    int idUsuario = 0;
    
    HttpSession sessao = request.getSession();
    String tipoLogin = (String) sessao.getAttribute("TIPO_LOGIN");
    
    if(tipoLogin.equals("P")){
        idProfissional = (int) sessao.getAttribute("ID_PROFISSIONAL");
        result = profissional.getProfessionalById(idProfissional);
    }
    
    if(tipoLogin.equals("S")){
        idSupervisor = (int) sessao.getAttribute("ID_SUPERVISOR");
        result = supervisor.getSupervisorById(idSupervisor);
    }
    idUsuario = (int) sessao.getAttribute("ID_USUARIO");
    
    String nome = result.getString("NOME");
      
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
  
  
  <title>Página Inicial Profissional</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons2/mobirise2.css">
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
  
  <section data-bs-version="5.1" class="menu menu2 cid-sJSYoE7XrK" once="menu" id="menu2-w">
    
    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a href="https://mobiri.se">
                        <img src="assets/images/broken-tooth-96x96.png" alt="Mobirise" style="height: 3rem;">
                    </a>
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-black display-7" href="https://mobiri.se">Saúde Digital</a></span>
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
                
                <div class="navbar-buttons mbr-section-btn"><a class="btn btn-secondary display-4" href="registroProfissional.jsp"><%=nome%></a></div>
            </div>
        </div>
    </nav>
</section>

<section data-bs-version="5.1" class="contacts1 cid-sKj2jy5oyC" id="contacts1-11">

    

    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2"><strong>Ações</strong></h3>
            <h4 class="mbr-section-subtitle mbr-fonts-style align-center mb-0 mt-2 display-5">Bem-vindo à sua Saúde</h4>
        </div>
        <div class="row justify-content-center mt-4">
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-letter mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style mb-2 display-2"><strong>Cadastrar Paciente</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">Informações pessoais e Login</p>
                        <h5 class="link mbr-fonts-style display-7"><a href="cadastroUsuario.html" class="text-secondary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-mobile-2 mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style align-center mb-2 display-2"><strong>Ficha de Identificação</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">
                            Detalhes do cadastro do Paciente</p>
                        <h5 class="link mbr-black mbr-fonts-style display-7"><a href="fichaIdentificacao.jsp" class="text-secondary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="contacts1 cid-sKlVLcAqSy" id="contacts1-1v">
    <div class="container">
        <div class="row justify-content-center mt-4">
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-letter mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style mb-2 display-2">
                            <strong>Iniciar Atendimento</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">Preencher questionário de saúde e gerar prontuário</p>
                        <h5 class="link mbr-fonts-style display-7"><a href="questionarioSaude.html" class="text-primary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-mobile-2 mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style align-center mb-2 display-2">
                            <strong>Gerar Prontuário</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">
                            Gerar prontuário de cliente com base nos atendimentos prestasdos</p>
                        <h5 class="link mbr-black mbr-fonts-style display-7"><a href="page1.html" class="text-primary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="contacts1 cid-sKm270EV61" id="contacts1-27">
    <div class="container">
        <div class="row justify-content-center mt-4">
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-letter mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style mb-2 display-2">
                            <strong>Gerar Atestado</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">
                            Gerar atestado para Paciente ou acompanhante</p>
                        <h5 class="link mbr-fonts-style display-7"><a href="page1.html" class="text-primary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-mobile-2 mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style align-center mb-2 display-2">
                            <strong>Gerar Receituário</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">
                            Gerar receituário sobre atendimento para Paciente</p>
                        <h5 class="link mbr-black mbr-fonts-style display-7"><a href="page1.html" class="text-primary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

    <%if(tipoLogin.equals("S")){
    
   %>      
<section data-bs-version="5.1" class="contacts1 cid-sKm15zx310" id="contacts1-26">
    <div class="container">
        <div class="mbr-section-head">
            
            <h4 class="mbr-section-subtitle mbr-fonts-style align-center mb-0 mt-2 display-5">Supervior Area</h4>
        </div>
        <div class="row justify-content-center mt-4">
            <div class="card col-12 col-lg-6">
                <div class="card-wrapper">
                    <div class="card-box align-center">
                        <div class="image-wrapper">
                            <span class="mbr-iconfont mobi-mbri-letter mobi-mbri"></span>
                        </div>
                        <h4 class="card-title mbr-fonts-style mb-2 display-2"><strong>Encaminhamento&nbsp;</strong></h4>
                        <p class="mbr-text mbr-fonts-style mb-2 display-4">
                            Encaminhar paciente para outra área/procedimento da Clínica</p>
                        <h5 class="link mbr-fonts-style display-7"><a href="encaminhamento.html" class="text-primary">Acessar --&gt;</a></h5>
                    </div>
                </div>
            </div>            
        </div>
    </div>
</section>
<%    }%>

<section data-bs-version="5.1" class="footer4 cid-sJT1oI5utu" once="footers" id="footer4-x">

    
    
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
