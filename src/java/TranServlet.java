/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.PaymentService_Service;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/TranServlet"})
public class TranServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ASMBank-war/PaymentService.wsdl")
    private PaymentService_Service service;

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
        String pinCode = request.getParameter("pin");
        String clientID = request.getParameter("clientID");
        double money = Double.parseDouble(request.getParameter("money"));
        String tranName = request.getParameter("tranName");
        String type = request.getParameter("type");
        if(!"0".equals(type)){
            type = "1";
        }
        String code = request.getParameter("code");
        if(payment(money,code,pinCode,clientID,Integer.parseInt(type),tranName)){
            request.getRequestDispatcher("success.jsp").forward(request, response);
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

    private boolean payment(double money, java.lang.String code, java.lang.String pin, java.lang.String clientID, int payer, java.lang.String tranName) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.PaymentService port = service.getPaymentServicePort();
        return port.payment(money, code, pin, clientID, payer, tranName);
    }

    private String login(java.lang.String id, java.lang.String password) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.PaymentService port = service.getPaymentServicePort();
        return port.login(id, password);
    }

}
