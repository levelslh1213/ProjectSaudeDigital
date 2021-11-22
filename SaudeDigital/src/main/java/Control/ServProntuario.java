/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Prontuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServProntuario extends HttpServlet {
    
    Prontuario prontuario;
    String e;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        getDataFromRequest(request);
        redirectRequest(request, response, "inicialProfissional.jsp");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServProntuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServProntuario at " + this.prontuario.getAluno() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void getDataFromRequest(HttpServletRequest request){
        String  supervisor = request.getParameter("edtSupervisor"),
                paciente = request.getParameter("edtPaciente"),
                profissional = request.getParameter("edtProfissional"),
                historia = request.getParameter("edtHistoria"),
                anotacoes = request.getParameter("edObs");
        
        fillProntuarioInfo(supervisor, paciente, profissional, historia, anotacoes);       
        
    }
    private void fillProntuarioInfo(
            String supervisor, String paciente, String profissional, String historia, String anotacoes){
        
        this.prontuario = new Prontuario();
        this.prontuario.setProfessor(supervisor);
        this.prontuario.setPaciente(paciente);
        this.prontuario.setAluno(profissional);
        this.prontuario.setHistoria(historia);
        this.prontuario.setAnotacoes(anotacoes);
    }
    
    private void redirectRequest(HttpServletRequest request, HttpServletResponse response, String destino){
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        
        HttpSession session = request.getSession();

        session.setAttribute("PRONTUARIO", this.prontuario);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
