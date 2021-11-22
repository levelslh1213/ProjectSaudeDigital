/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.QuestionarioSaude;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServQuestionario extends HttpServlet {

    String destino = "/inicialProfissional.jsp";
    QuestionarioSaude questionario;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void getResponse(HttpServletRequest request){

        String cpf = request.getParameter("edtCpf");
        String queixa = request.getParameter("edtQueixa");
        String hitdoenca = request.getParameter("edtHistoria");
        String hemorragia = request.getParameter("cmbHemorragia");
        String alergia = request.getParameter("cmbAlergia");
        String infeccioso = request.getParameter("cmbReumatismo");
        String cardiovascular = request.getParameter("cmbDisturbio");
        String gastrite = request.getParameter("cmbGastrite");
        String diabetico = request.getParameter("cmbDiabetico");
        String desmaiou = request.getParameter("cmbDesmaio");
        String tratamento_med = request.getParameter("cmbTratamento");
        String toma_medc = request.getParameter("cmbMedicamento");
        String doente_5 = request.getParameter("cmbOperado");
        String habitos = request.getParameter("cmbVicios");
        String ansie_depre = request.getParameter("cmbDepressao");
        String tuberculose = request.getParameter("cmb1Tuberculose"); 
        String sarampo = request.getParameter("cmb1Sarampo");
        String sifilis = request.getParameter("cmb1Sifilis");
        String caxumba = request.getParameter("cmb1Caxumba");
        String hepatite = request.getParameter("cmb1Hepatite");
        String varicela = request.getParameter("cmb1Varicela");
        String aids = request.getParameter("cmb1Aids");
        String outra_doenca = request.getParameter("cmb1Outros");
        String fumanete = request.getParameter("cmb1Fumante");
        String histgest = request.getParameter("edtGestação");
        String parto = request.getParameter("cmbParto");
        String prob_parto = request.getParameter("cmbProblema");
        String amamentacao = request.getParameter("cmbAlimentacao");
        String anestesia = request.getParameter("cmbAnestesia");
        String grave_doenca = request.getParameter("cmbDoenca");
        String vacina = request.getParameter("cmbVacinada");
        String anos = request.getParameter("cmbAnos");
        String aprendizado = request.getParameter("cmbLar");
        String estado_ani = request.getParameter("cmbAnimico");
        String sono = request.getParameter("cmbSono");
        String conduta_psic = request.getParameter("cmbPsicomotora");
        String alimentacao = request.getParameter("cmbAlimentacao1");
        String sociabilidade = request.getParameter("cmbSociabilidade");
        String conduta_pato = request.getParameter("cmbPatologia");
        String labio = request.getParameter("cmbLabios");
        String mucosa = request.getParameter("cmbMucosa");
        String lingua = request.getParameter("cmbLingua");
        String boca = request.getParameter("cmbSoalho");
        String palato = request.getParameter("cmbPalato");
        String garganta = request.getParameter("cmbGarganta");
        String palato_mole = request.getParameter("cmbPalato2");
        String alveolar = request.getParameter("cmbMucosa2");
        String gengiva = request.getParameter("cmbGengivas");
        String glandula = request.getParameter("cmbGlandulas");
        String linfonodos = request.getParameter("cmbLinfonodos");
        String atm = request.getParameter("cmbAtm");
        String musculo = request.getParameter("cmbMusculos");
        String oclusao = request.getParameter("cmbOclusao");
        String pressaomin = request.getParameter("edtPressaomin");
        String pressaomax = request.getParameter("edtPressaomax");
        String diagpresuntivo = request.getParameter("edtPresuntivo");
        String examecompl = request.getParameter("edtComplementares");
        String diagdef = request.getParameter("edtDefinitivo");
        String tratamento = request.getParameter("edtTratamento");
        String planotrat = request.getParameter("edtPlanoTratamento");
        String atendimentourg = request.getParameter("ckUrgencia");
        
        
        
        parte1(cpf, queixa, hitdoenca, hemorragia, alergia, infeccioso, cardiovascular, gastrite, diabetico, desmaiou, 
              tratamento_med, toma_medc, doente_5, habitos, ansie_depre, tuberculose, sarampo, sifilis, caxumba, 
              hepatite, varicela, aids, outra_doenca, fumanete, histgest, parto, prob_parto, amamentacao, 
              anestesia, grave_doenca, vacina, anos, aprendizado, estado_ani, sono, conduta_psic, alimentacao, 
              sociabilidade, conduta_pato, labio, mucosa, lingua, boca, palato, garganta, palato_mole, alveolar, 
              gengiva, glandula, linfonodos, atm, musculo, oclusao, pressaomin, pressaomax, diagpresuntivo, examecompl, 
              diagdef, tratamento, planotrat, atendimentourg);
    }
    
    public void parte1(String cpf, String queixa,String hitdoenca,String hemorragia,String alergia,String infeccioso,String cardiovascular,String gastrite,String diabetico,String desmaiou, 
              String tratamento_med,String toma_medc,String doente_5,String habitos,String ansie_depre,String tuberculose,String sarampo,String sifilis,String caxumba, 
              String hepatite,String varicela,String aids,String outra_doenca,String fumanete,String histgest,String parto,String prob_parto,String amamentacao, 
              String anestesia,String grave_doenca, String vacina, String anos, String aprendizado, String estado_ani, String sono,String conduta_psic, String alimentacao, 
              String sociabilidade,String conduta_pato,String labio,String mucosa,String lingua, String boca,String palato, String garganta, String palato_mole, String alveolar, 
              String gengiva, String glandula, String linfonodos, String atm, String musculo,String oclusao,String pressaomin,String pressaomax,String diagpresuntivo,String examecompl, 
              String diagdef, String tratamento, String planotrat,String atendimentourg){
    
        questionario = new QuestionarioSaude();
        questionario.setCpf(cpf);
        questionario.setQueixa(queixa);
        questionario.setHitdoenca(hitdoenca);
        questionario.setHemorragia(hemorragia);
        questionario.setAlergia(alergia);
        questionario.setInfeccioso(infeccioso);
        questionario.setCardiovascular(cardiovascular);
        questionario.setGastrite(gastrite);
        questionario.setDiabetico(diabetico);
        questionario.setDesmaiou(desmaiou);
        questionario.setTratamento_med(tratamento_med);
        questionario.setToma_medc(toma_medc);
        questionario.setDoente_5(doente_5);
        questionario.setHabitos(habitos);
        questionario.setAnsie_depre(ansie_depre);
        questionario.setTuberculose(tuberculose);
        questionario.setSarampo(sarampo);
        questionario.setSifilis(sifilis);
        questionario.setCaxumba(caxumba);
        questionario.setHepatite(hepatite);
        questionario.setVaricela(varicela);
        questionario.setAids(aids);
        questionario.setOutra_doenca(outra_doenca);
        questionario.setFumanete(fumanete);
        questionario.setHistgest(histgest);
        questionario.setParto(parto);
        questionario.setProb_parto(prob_parto);
        questionario.setAmamentacao(amamentacao);
        questionario.setAnestesia(anestesia);
        questionario.setGrave_doenca(grave_doenca);
        questionario.setVacina(vacina);
        questionario.setAprendizado(aprendizado);
        questionario.setEstado_ani(estado_ani);
        questionario.setSono(sono);
        questionario.setConduta_psic(conduta_psic);
        questionario.setAlimentacao(alimentacao);
        questionario.setSociabilidade(sociabilidade);
        questionario.setConduta_pato(conduta_pato);
        questionario.setLabio(labio);
        questionario.setMucosa(mucosa);
        questionario.setLingua(lingua);
        questionario.setBoca(boca);
        questionario.setPalato(palato);
        questionario.setGarganta(garganta);
        questionario.setPalato_mole(palato_mole);
        questionario.setAlveolar(alveolar);
        questionario.setGengiva(gengiva);
        questionario.setGlandula(glandula);
        questionario.setLinfonodos(linfonodos);
        questionario.setAtm(atm);
        questionario.setMusculo(musculo);
        questionario.setOclusao(oclusao);
        questionario.setPressaomin(pressaomin);
        questionario.setPressaomax(pressaomax);
        questionario.setDiagpresuntivo(diagpresuntivo);
        questionario.setExamecompl(examecompl);
        questionario.setDiagdef(diagdef);
        questionario.setTratamento(tratamento);
        questionario.setPlanotrat(planotrat);
        questionario.setAtendimentourg(atendimentourg);
    }
    
    
    public void redirecionar(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
        session.setAttribute("Questionario", questionario);
        
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        getResponse(request);
        redirecionar(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServQuest1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServQuest1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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