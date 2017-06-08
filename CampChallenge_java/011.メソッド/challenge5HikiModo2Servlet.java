/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCUser
 */
public class challenge5HikiModo2Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    void pro(String id,PrintWriter pw){
        
    String[] pro1 = {"1","森本","9月",null};
    
for (int i = 1; i <pro1.length; i++){
if (i==3){
continue;
}
 pw.print(pro1[i]);
 pw.print("<br>");
 }  
    String[] pro2 = {"2","山田","10月","東京"};
    
for (int i = 1; i <pro2.length; i++){
 pw.print(pro2[i]);
 pw.print("<br>");
 }


 
    String[] pro3 = {"3","田中","11月","名古屋"}; 
 
    for (int i = 1; i <pro3.length; i++){
 pw.print(pro3[i]);
 pw.print("<br>");
 }



   
    
//    pw.print(pro1+"<br>");
//    pw.print(pro2+"<br>");
//    pw.print(pro3+"<br>");
//    pw.print("<br>");
    
    //idが1だったときpro1を返す
    //idが2だったときpro2を返す
    //idが3だったときpro3を返す
   
//    if ( id == "1" ){
//        return pro1;
//        
//    }else if (id == "2") {
//        return pro2;
//        
//    }else if(id == "3"){
//        return pro3;
//        
//    }else{
//        return null;
//    }

   

}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
         pro("aa",out);   
//            String[] modori = pro("1");
//         
//            for (int i = 1; i <modori.length; i++){
//            out.print(modori[i]);
//            out.print("<br>");
//            }
//            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet challenge5HikiModo2Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
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
