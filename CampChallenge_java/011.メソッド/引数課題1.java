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
public class challenge2Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // サーブレットクラス内
// 渡された数字を２乗する関数です
// ただし、数字が渡されなかった場合には、100を２乗します
void kakeru2(int num, PrintWriter pw) {
    pw.print(num + "は、" );
    if(num%2==0){
            pw.print("偶数です"+"<br>");
        }else{
            pw.print("奇数です"+"<br>");                         
        }
}
    // デフォルト値の設定
// 下記のメソッドは、PrintWriterだけ渡すと、上で宣言された
// 引数が２つのkakeru2を呼び出します
// その際、numに100が強制的に適用されます
// この100がデフォルト値となります
void kakeru2(PrintWriter pw) {
    kakeru2(65536, pw);
}


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
         
          
              
           

       
        // 1.普通に数値を渡す場合
    // この場合、引数が２つのkakeru2が呼び出されます
    // 50の2乗が表示されます
    kakeru2(49, out); 
kakeru2(100, out); 
kakeru2(1781, out); 
kakeru2(1564, out); 
    // 2.数値を省略する場合
    // この場合、引数が1つのkakeru2が呼び出されます
    // デフォルト値の100が適用され、100の2乗が表示されます
    
     kakeru2(out);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet challenge2Servlet</title>");            
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
