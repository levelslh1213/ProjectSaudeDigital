/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Endereco;
import Model.Paciente;
import Model.Supervisor;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
public class ServCadastroPaciente extends HttpServlet {

    Paciente paciente;
    Usuario usuario;
    Endereco endereco;
    
    int idPaciente = 0;
    int idUsuario = 0;
    int idEndereco = 0;
    
    String message = "";
    String tipoLogin = "";
    String tipoCadastro = "";
    String e = "";
    String redirecParam = "";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        getDataFromRequest(request);
        
        HttpSession session = request.getSession();
        if(tipoCadastro.equals("Pessoa")){
            request.setAttribute("ID_PACIENTE_CADASTRADO", this.idPaciente);
            if(this.redirecParam != null){
                redirectRequest(request, response, "fichaIdentificacao.jsp");
            }
            else{
                redirectRequest(request, response, "inicialProfissional.jsp");
            }
        }
        else if(tipoCadastro.equals("Pesquisa")){
            request.setAttribute("ID_PACIENTE_CADASTRADO", this.idPaciente);
            redirectRequest(request, response, "fichaIdentificacao.jsp");
        }
        else if(tipoCadastro.equals("Ficha")){
            redirectRequest(request, response, "inicialProfissional.jsp");
        }
        else if(tipoCadastro.equals("Update")){
            redirectRequest(request, response, "inicialPaciente.jsp");
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServReqObrigatorio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Tipo login = " + this.tipoLogin+ "</h1><br>");
            out.println("<h1>Servlet Tipo login = " + this.tipoCadastro+ "</h1><br>");
            out.println("<h1>Servlet idUsuario = " + this.idUsuario+ "</h1><br>");
            out.println("<h1>Servlet idPaciente = " + this.idPaciente+ "</h1><br>");
            out.println("<h1>Servlet idEndereco = " + this.idEndereco+ "</h1><br>");
            out.println("<h1>Servlet message = " + this.message+ "</h1><br>");
            out.println("<h1>Servlet Exception = " + this.e+ "</h1><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void getDataFromRequest(HttpServletRequest request) throws ClassNotFoundException, ParseException{
    
        this.tipoCadastro = request.getParameter("edtTipoCadastro");
        this.redirecParam = request.getParameter("ckIdentificacao");
        
        if(this.tipoCadastro.equals("Pessoa")){
            getPersonDataFromRequest(request);
            createUserForPaciente();
            insertPersonInDb();            
        }
        else if(this.tipoCadastro.equals("Pesquisa")){
            getSearchDataFromRequest(request);
        }
        else if(this.tipoCadastro.equals("Ficha")){
            getFichaDataFromRequest(request);
            insertFichaInfoInDB();
        }
        else if(this.tipoCadastro.equals("Update")){
            getUpdateDataFromRequest(request);
            updateInfoInDB();
        }    
    }
    
    private void updateInfoInDB() throws ClassNotFoundException, ParseException{
        this.idEndereco = this.paciente.getAddressByPacienteId(this.idPaciente);
        this.message = this.paciente.getEndereco().updateAddressInDB(this.paciente.getEndereco(), this.idEndereco);
        this.message = this.paciente.updatePacientelInDB(this.paciente, this.idPaciente);
        
    }
    
    private void getUpdateDataFromRequest(HttpServletRequest request) throws ClassNotFoundException{
        this.idPaciente = Integer.parseInt(request.getParameter("edtIdPaciente"));
        float peso = Float.parseFloat(request.getParameter("edtPeso")),
              altura = Float.parseFloat(request.getParameter("edtAltura"));
        
        String cor = request.getParameter("cmbCor"),
               estadoCivil = request.getParameter("cmbEstadoCivil"),
               escolaridade = request.getParameter("cmbEscolaridade"),
               naturalidade = request.getParameter("edtNaturalidade"),
               estadoNaturalizado = request.getParameter("edtEstado");
        
        //getAddresInfo
        
        String rua = request.getParameter("edtRua"), 
                bairro = request.getParameter("edtBairro"), 
                complemento = request.getParameter("edtComplemento"), 
                cep = request.getParameter("edtCep"), 
                cidade = request.getParameter("edtCidade"), 
                estado = request.getParameter("edtEstado"),
                numero = request.getParameter("edtNumero");
        
        String nome = request.getParameter("edtNome"), 
                cpf = request.getParameter("edtCpf"), 
                rg = request.getParameter("edtRg"), 
                dataNascimento = request.getParameter("edtDataNasc"),
                sexo = request.getParameter("cmbSexo"), 
                email = request.getParameter("edtEmail"), 
                telefone = request.getParameter("edtTelefone");
        
        fillUpdateInfo(peso, altura, cor, estadoCivil, escolaridade, naturalidade, estadoNaturalizado, rua, bairro, complemento, cep, cidade, estado, numero, nome, cpf, rg, dataNascimento, sexo, email, telefone);
    }
    
    
    
    private void fillUpdateInfo(
            float peso, float altura, String cor, String estadoCivil, String escolaridade, String naturalidade, String estadoNaturalizado, 
            String rua, String bairro, String complemento, String cep, String cidade, String estado, String numero,
            String nome, String cpf, String rg, String dataNascimento, 
            String sexo, String email, String telefone) throws ClassNotFoundException{
        
        this.paciente = new Paciente();
        this.paciente.setPeso(peso);
        this.paciente.setAltura(altura);
        this.paciente.setCor(cor);
        this.paciente.setEstadoCivil(estadoCivil);
        this.paciente.setEscolaridade(escolaridade);
        this.paciente.setNaturalidade(naturalidade);
        this.paciente.setEstado(estadoNaturalizado);
 
        
        endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setComplemento(complemento);
        endereco.setEstado(estado);
        endereco.setNumero(numero);
        
        this.paciente.setEndereco(endereco);
        
        this.message =this.paciente.getEndereco().getRua();
        this.paciente.setNome(nome);
        this.paciente.setCpf(cpf);
        this.paciente.setRg(rg);
        this.paciente.setDataNascimento(dataNascimento);
        this.paciente.setSexo(sexo);
        this.paciente.setEmail(email);
        this.paciente.setTelefone(telefone);
    }
    
    private void getFichaDataFromRequest(HttpServletRequest request) throws ClassNotFoundException{
        this.idPaciente = Integer.parseInt(request.getParameter("edtIdPaciente"));
        float peso = Float.parseFloat(request.getParameter("edtPeso")),
              altura = Float.parseFloat(request.getParameter("edtAltura"));
        
        String cor = request.getParameter("cmbCor"),
               estadoCivil = request.getParameter("cmbEstadoCivil"),
               escolaridade = request.getParameter("cmbEscolaridade"),
               naturalidade = request.getParameter("edtNaturalidade"),
               estadoNaturalizado = request.getParameter("edtEstado");
        
        //getAddresInfo
        
        String rua = request.getParameter("edtRua"), 
                bairro = request.getParameter("edtBairro"), 
                complemento = request.getParameter("edtComplemento"), 
                cep = request.getParameter("edtCep"), 
                cidade = request.getParameter("edtCidade"), 
                estado = request.getParameter("edtEstado"),
                numero = request.getParameter("edtNumero");
        

        fillFichaInfo(peso, altura, cor, estadoCivil, escolaridade, naturalidade, estadoNaturalizado, rua, bairro, complemento, cep, cidade, estado, numero);
        
    }
    
    private void fillFichaInfo(
            float peso, float altura, String cor, String estadoCivil, String escolaridade, String naturalidade, String estadoNaturalizado, 
            String rua, String bairro, String complemento, String cep, String cidade, String estado, String numero) throws ClassNotFoundException{
        
        this.paciente = new Paciente();
        this.paciente.setPeso(peso);
        this.paciente.setAltura(altura);
        this.paciente.setCor(cor);
        this.paciente.setEstadoCivil(estadoCivil);
        this.paciente.setEscolaridade(escolaridade);
        this.paciente.setNaturalidade(naturalidade);
        this.paciente.setEstado(estadoNaturalizado);
        
        
        endereco = new Endereco();
        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setComplemento(complemento);
        endereco.setEstado(estado);
        endereco.setNumero(numero);
        endereco.setRua(rua);
        
        this.paciente.setEndereco(endereco);
    }
    
    private void insertFichaInfoInDB() throws ClassNotFoundException, ParseException{
        this.idEndereco = this.paciente.getEndereco().insertAddressInDB(this.paciente.getEndereco());
        this.message = this.paciente.insertFichaInfoInDB(this.paciente, this.idEndereco, this.idPaciente);
    }
    
    private void getSearchDataFromRequest(HttpServletRequest request) throws ClassNotFoundException{
        //Person's infos
        String cpf = request.getParameter("edtCpf");
        
        this.paciente = new Paciente();
        this.idPaciente = this.paciente.getPacienteByCpf(cpf);
    }
    
    private void getPersonDataFromRequest(HttpServletRequest request){
        //Person's infos
        String nome = request.getParameter("edtNome"), 
                cpf = request.getParameter("edtCpf"), 
                rg = request.getParameter("edtRg"), 
                dataNascimento = request.getParameter("edtDataNasc"),
                sexo = request.getParameter("cmbSexo"), 
                email = request.getParameter("edtEmail"), 
                telefone = request.getParameter("edtTelefone");
        
        fillPersonInfo(nome, cpf, rg, dataNascimento, sexo, email, telefone);
    }
    
    private void fillPersonInfo(
            String nome, String cpf, String rg, String dataNascimento, 
            String sexo, String email, String telefone){
        
        this.paciente = new Paciente();
        this.paciente.setNome(nome);
        this.paciente.setCpf(cpf);
        this.paciente.setRg(rg);
        this.paciente.setDataNascimento(dataNascimento);
        this.paciente.setSexo(sexo);
        this.paciente.setEmail(email);
        this.paciente.setTelefone(telefone);    
    }
    
    private void insertPersonInDb() throws ClassNotFoundException, ParseException{
        this.idPaciente = this.paciente.InsertPersonsInfo(this.paciente, this.idUsuario);
    }   
        
    public void createUserForPaciente() throws ClassNotFoundException{
        this.usuario = new Usuario();
        this.usuario.setLogin(this.paciente.getNome());
        this.usuario.setSenha(this.paciente.getCpf());
        
        this.idUsuario = usuario.insertUserInDB(usuario);
    }
    
    
    private void redirectRequest(HttpServletRequest request, HttpServletResponse response, String destino){
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            this.e = e.getMessage();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServCadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServCadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServCadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServCadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
