/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Encaminhamento;
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
public class ServEncaminhamento extends HttpServlet {

    Encaminhamento encaminhamento;
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
            out.println("<title>Servlet ServEncaminhamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServEncaminhamento at " + this.encaminhamento.getDisciplina() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void getDataFromRequest(HttpServletRequest request){
        String supervisor = request.getParameter("edtSupervisor"),
                paciente = request.getParameter("edtPaciente"),
                profissional = request.getParameter("edtProfissional"),
                disciplina = request.getParameter("cmbDisciplina"),
                graducao = request.getParameter("cmbGraducao"),
                pos = request.getParameter("cmbPos"),
                projeto = request.getParameter("cmbProjeto"),
                obs = request.getParameter("edtObs"),
                data = request.getParameter("edtData");
        
        fillEncaminhamentoInfo(supervisor, paciente, profissional, disciplina, graducao, pos, projeto, obs, data);       
        
    }
    
    private void fillEncaminhamentoInfo(
            String supervisor, String paciente, String profissional, String disciplina, 
            String graducao, String pos, String projeto, String obs, String data){
        
        this.encaminhamento = new Encaminhamento();
        this.encaminhamento.setSupervisor(supervisor);
        this.encaminhamento.setPaciente(paciente);
        this.encaminhamento.setProfissional(profissional);
        this.encaminhamento.setDisciplina(disciplina);
        this.encaminhamento.setGraduacao(graducao);
        this.encaminhamento.setPos(pos);
        this.encaminhamento.setProjeto(projeto);
        this.encaminhamento.setObs(obs);
        this.encaminhamento.setData(data);
    }
    
    private void redirectRequest(HttpServletRequest request, HttpServletResponse response, String destino){
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        
        HttpSession session = request.getSession();

        session.setAttribute("ENCAMINHAMENTO", this.encaminhamento);
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
