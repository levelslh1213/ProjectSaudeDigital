/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Paciente;
import Model.Profissional;
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
public class ServLogin extends HttpServlet {

    Usuario usuario;
    Paciente paciente;
    Profissional profissional;
    Supervisor supervisor;
    
    int idPaciente;
    int idProfissional;
    int idSupervisor;
    int idUsuario;
    
    String message = "";
    String tipoLogin = "";
    String e = "";
    
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
        if(this.idUsuario != 0){
            if((this.tipoLogin.equals("P")) || (this.tipoLogin.equals("S"))){
                redirectRequest(request,response,"inicialProfissional.jsp");
            }
            else{
                redirectRequest(request,response,"inicialPaciente.jsp");
            }
        }
        else{
            redirectRequest(request,response,"login.jsp");
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
            out.println("<h1>Servlet idUsuario = " + this.idUsuario+ "</h1><br>");
            out.println("<h1>Servlet idProfissional = " + this.idProfissional+ "</h1><br>");
            out.println("<h1>Servlet idSupervisor = " + this.idSupervisor+ "</h1><br>");
            out.println("<h1>Servlet idPaciente = " + this.idPaciente+ "</h1><br>");
            out.println("<h1>Servlet message = " + this.message+ "</h1><br>");
            out.println("<h1>Servlet Exception = " + this.e+ "</h1><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void getDataFromRequest(HttpServletRequest request) throws ClassNotFoundException, ParseException{
        String login = request.getParameter("edtLogin"),
               senha = request.getParameter("edtSenha"),
               tipoLogin = request.getParameter("cmbTipoLogin");
               
        fillLoginInfo(login, senha, tipoLogin);
    }
    
    private void fillLoginInfo(
        String login, String senha, String tipoLogin) throws ClassNotFoundException, ParseException{

        this.usuario = new Usuario();
        this.usuario.setLogin(login);
        this.usuario.setSenha(senha);
        this.idUsuario = this.usuario.validateLogin(this.usuario);
        
        this.tipoLogin = tipoLogin;
        
        if(tipoLogin.equals("P")){
            this.profissional = new Profissional();
            this.idProfissional =  this.profissional.getProfissionalByUser(this.idUsuario);
        }
        else if(tipoLogin.equals("S")){
            this.supervisor = new Supervisor();
            this.idSupervisor = this.supervisor.getSupervisorByUser(this.idUsuario);
        }
        else if(tipoLogin.equals("C")){
            this.paciente = new Paciente();
            this.idPaciente = this.paciente.getPacienteByUser(this.idUsuario);
        }
        
        
    }
    
    private void redirectRequest(HttpServletRequest request, HttpServletResponse response, String destino){
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        if(this.tipoLogin.equals("P")){
             request.setAttribute("ID_PROFISSIONAL", this.idProfissional);
         }
        else if(this.tipoLogin.equals("S")){
             request.setAttribute("ID_SUPERVISOR", this.idSupervisor);
        }
        else if(this.tipoLogin.equals("C")){
            request.setAttribute("ID_PACIENTE", this.idPaciente);
        }
        request.setAttribute("ID_USUARIO", this.idUsuario);
        request.setAttribute("TIPO_LOGIN", this.tipoLogin);
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
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
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
