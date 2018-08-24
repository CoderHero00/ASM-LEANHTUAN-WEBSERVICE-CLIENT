/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import service.PaymentService_Service;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/HistoryQuery"})
public class HistoryQuery extends HttpServlet {

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
        List<EntityHistory> historyList = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String username = request.getParameter("ID");
        String password = request.getParameter("Password");
        String StartD = request.getParameter("StartD");
        String EndD = request.getParameter("EndD");
        int role = Integer.parseInt(request.getParameter("role"));
        List<String> history = new ArrayList<>();
        try { 
            Date StartDat = format.parse(StartD);
            Date EndDat = format.parse(EndD);
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(StartDat);
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            GregorianCalendar d = new GregorianCalendar();
            d.setTime(EndDat);
            XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(d);
        if(role == 1){
            history = pHistory(username, password,date2, date1);
            for(String x: history){
               EntityHistory historyEnti = new EntityHistory();
               String[] split = x.split(" ");
               historyEnti.setDate(split[4]);
               historyEnti.setFee(split[3]);
               historyEnti.setMoney(split[2]);
               historyEnti.setName(split[1]);
               historyEnti.setID(split[0]);
               historyList.add(historyEnti);
            }
        }else{
            history = uHistory(password, username,date2,date1);
            for(String x: history){
               EntityHistory historyEnti = new EntityHistory();
               String[] split = x.split(" ");
               historyEnti.setDate(split[4]);
               historyEnti.setFee(split[3]);
               historyEnti.setMoney(split[2]);
               historyEnti.setName(split[1]);
               historyEnti.setID(split[0]);
               historyList.add(historyEnti);
            }
        }} catch (ParseException | DatatypeConfigurationException ex) {
            Logger.getLogger(HistoryQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session=request.getSession();
        session.setAttribute("list",historyList);
        request.getRequestDispatcher("Show.jsp").forward(request, response);
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


    

    private java.util.List<java.lang.String> pHistory(java.lang.String id, java.lang.String password, javax.xml.datatype.XMLGregorianCalendar sDate, javax.xml.datatype.XMLGregorianCalendar eDate) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.PaymentService port = service.getPaymentServicePort();
        return port.pHistory(id, password, sDate, eDate);
    }

    private java.util.List<java.lang.String> uHistory(java.lang.String pin, java.lang.String id, javax.xml.datatype.XMLGregorianCalendar sDate, javax.xml.datatype.XMLGregorianCalendar eDate) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.PaymentService port = service.getPaymentServicePort();
        return port.uHistory(pin, id, sDate, eDate);
    }

    
    
    

}
