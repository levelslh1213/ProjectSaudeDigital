/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Endereco;
import Model.Profissional;
import Model.Supervisor;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
public class ServRegistroProfissional extends HttpServlet {
    Profissional profissional;
    Supervisor supervisor;
    Endereco endereco;
    String e;
    Usuario usuario;
    int idEndereco = 0;
    int idProfissional = 0;
    int idSupervisor = 0;
    int idUsuario = 0;
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
        
        //insertDataInSession(request);
        if(request.getParameter("edtTipoOperacao").equals("UPDATE")){
            getDataFromRequest(request);
            redirectRequest(request, response, "inicialProfissional.html");
        }
        else{
            processDeleteRegister(request);
            redirectRequest(request, response, "index.html");
        }
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServReqObrigatorio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServReqObrigatorio at " + this.idEndereco+ "</h1><br>");
            out.println("<h1>Servlet ServReqObrigatorio at " + this.idProfissional + "</h1>");
            out.println("<h1>Servlet ServReqObrigatorio at " + this.e + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void processDeleteRegister(HttpServletRequest request) throws ClassNotFoundException{
        getPrimaryKeysValues(request);
        
        this.endereco = new Endereco();
        this.profissional = new Profissional();
        
        this.e = this.profissional.deleteProfissionalFromDB(this.idProfissional);
        this.e = this.endereco.deleteAddressFromDB(this.idEndereco);
        
    }

    private void getDataFromRequest(HttpServletRequest request) throws ClassNotFoundException, ParseException{
        getPrimaryKeysValues(request);
        getProfessionalInfo(request);
    }
    
    private void getPrimaryKeysValues(HttpServletRequest request) throws ClassNotFoundException{
        HttpSession sessao = request.getSession();
        this.idProfissional =(Integer) sessao.getAttribute("ID_PROFISSIONAL");
        this.idEndereco = getProfessionalAddress();
    }
    
    private int getProfessionalAddress() throws ClassNotFoundException{
        this.profissional = new Profissional();
        return this.profissional.getAddressByProfessionalId(this.idProfissional);
    }
    
    private void getProfessionalInfo(HttpServletRequest request) throws ClassNotFoundException, ParseException{
        //Person's Info
        String nome = request.getParameter("edtNome"), 
                cpf = request.getParameter("edtCpf"), 
                rg = request.getParameter("edtRg"), 
                dataNascimento = request.getParameter("edtDataNasc"),
                sexo = request.getParameter("cmbSexo"), 
                email = request.getParameter("edtEmail"), 
                telefone = request.getParameter("edtTelefone"),
                cro = request.getParameter("edtCro");
        //Address's Info
        String rua = request.getParameter("edtRua"), 
                bairro = request.getParameter("edtBairro"), 
                complemento = request.getParameter("edtComplemento"), 
                cep = request.getParameter("edtCep"), 
                cidade = request.getParameter("edtCidade"), 
                estado = request.getParameter("edtEstado"),
                numero = request.getParameter("edtNumero");
        
        fillProfessionalInfo(nome,cpf, rg, dataNascimento, sexo, email, telefone, cro, rua, bairro, complemento, cep, cidade, estado, numero);
    }
    
    private void getSupervisorInfo(HttpServletRequest request) throws ClassNotFoundException{
        //Person's Info
        String nome = request.getParameter("edtNome"), 
                cpf = request.getParameter("edtCpf"), 
                rg = request.getParameter("edtRg"), 
                dataNascimento = request.getParameter("edtDataNasc"), 
                sexo = request.getParameter("cmbSexo"), 
                email = request.getParameter("edtEmail"), 
                telefone = request.getParameter("edtTelefone"),
                cro = request.getParameter("edtCro");
        //Address's Info
        String rua = request.getParameter("edtRua"), 
                bairro = request.getParameter("edtBairro"), 
                complemento = request.getParameter("edtComplemento"), 
                cep = request.getParameter("edtCep"), 
                cidade = request.getParameter("edtCidade"), 
                estado = request.getParameter("edtEstado"),
                numero = request.getParameter("edtNumero");
        
        fillSupervisorInfo(nome,cpf, rg, dataNascimento, sexo, email, telefone, cro, rua, bairro, complemento, cep, cidade, estado, numero);
    }
    
    private void fillProfessionalInfo(
        String nome, String cpf, String rg, String dataNascimento, String sexo, String email, String telefone, String cro,
        String rua, String bairro, String complemento, String cep, String cidade, String estado, String numero) throws ClassNotFoundException, ParseException{

        
        this.profissional = new Profissional();
        this.profissional.setNome(nome);
        this.profissional.setCpf(cpf);
        this.profissional.setRg(rg);
        this.profissional.setDataNascimento(dataNascimento);
        this.profissional.setSexo(sexo);
        this.profissional.setEmail(email);
        this.profissional.setTelefone(telefone);
        this.profissional.setCro(cro);
        
        endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setComplemento(complemento);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setNumero(numero);
        
        this.profissional.setEndereco(endereco);
        this.e = this.profissional.getEndereco().updateAddressInDB(this.profissional.getEndereco(), this.idEndereco);
        this.e = this.profissional.updateProfissionalInDB(this.profissional, this.idProfissional);
        /*
        this.idUsuario = createUserForProfessional(this.profissional);
        this.idProfissional = this.profissional.insertProfessionalInDB(this.profissional, this.idEndereco, this.idUsuario);
        */
    }
    
    private void fillSupervisorInfo(
        String nome, String cpf, String rg, String dataNascimento, String sexo, String email, String telefone, String cro,
        String rua, String bairro, String complemento, String cep, String cidade, String estado, String numero) throws ClassNotFoundException{
        int idEndereco = 0;
        
        this.supervisor = new Supervisor();
        this.supervisor.setNome(nome);
        this.supervisor.setCpf(cpf);
        this.supervisor.setRg(rg);
        this.supervisor.setDataNascimento(dataNascimento);
        this.supervisor.setSexo(sexo);
        this.supervisor.setEmail(email);
        this.supervisor.setTelefone(telefone);
        this.supervisor.setCro(cro);
        
        endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setComplemento(complemento);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setNumero(numero);
        
        this.supervisor.setEndereco(endereco);
        /*idEndereco = this.profissional.getEndereco().insertAddressInDB(this.profissional.getEndereco());
        this.profissional.insertProfessionalInDB(this.profissional, idEndereco);
        */
    }

    private void redirectRequest(HttpServletRequest request, HttpServletResponse response, String destino){
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        
        HttpSession session = request.getSession();

        if(request.getParameter("edtTipoProfissional").equals("P")){
             session.setAttribute("PROFISSIONAL", this.profissional);
             session.setAttribute("ID_PROFISSIONAL", this.idProfissional);
         }
         else{
             session.setAttribute("SUPERVISOR", this.supervisor);
             session.setAttribute("ID_SUPERVISOR", this.idSupervisor);
         }
        
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
            Logger.getLogger(ServRegistroProfissional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServRegistroProfissional.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServRegistroProfissional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServRegistroProfissional.class.getName()).log(Level.SEVERE, null, ex);
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
