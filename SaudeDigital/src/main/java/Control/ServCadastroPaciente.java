/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
    
    int idPaciente = 0;
    int idUsuario = 0;
    
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
                redirectRequest(request, response, "fichaIdentificacao.html");
            }
            else{
                redirectRequest(request, response, "inicialProfissional.jsp");
            }
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
            insertPersonInDb();
            createUserForPaciente();
            return;
        }
        
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
        this.idPaciente = this.paciente.InsertPersonsInfo(this.paciente);
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
