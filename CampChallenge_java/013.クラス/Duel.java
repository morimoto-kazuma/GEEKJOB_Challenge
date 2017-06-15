/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

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
public class Duel extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            Dealer dealer = new Dealer();
            User user = new User();
            int DealerCount = 0;
            int UserCount = 0;

            dealer.setCard(dealer.deal());
//            out.print(dealer.myCards);
//            out.print(dealer.open()+"<br>");

            user.setCard(user.deal1());
//            out.print(user.myCards);
//            out.print(user.open());

//            trueならhit、falseなら何もしない。
            out.print("■ディーラー側■" + "<br>" + "<br>");
            if (dealer.checkSum() == true) {
                for (int i = 0; dealer.open() <= 16; i++) {
                    dealer.setCard(dealer.hit());
                    DealerCount++;
                }
                out.print(dealer.myCards + "<br>" + "<br>");
                out.print("Hit！" + "✕" + DealerCount + "回" + "<br>" + "<br>");
            } else if (dealer.checkSum() == false) {
                out.print(dealer.myCards + "<br>" + "<br>");
                out.print("Stand！" + "<br>" + "<br>");
            }

            if (dealer.open() == 21) {
                out.print("合計：「21」(ブラックジャック！)" + "<br>" + "<br>");
            } else if (dealer.open() > 21) {
                out.print("「...bust！」" + "<br>" + "<br>");
            } else {
                out.print("合計：「" + dealer.open() + "」" + "<br>" + "<br>");
            }

            out.print("-----------------------------" + "<br>" + "<br>");

            out.print("■ユーザー側■" + "<br>" + "<br>");
            if (user.checkSum() == true) {
                for (int i = 0; user.open() <= 16; i++) {
                    user.setCard(user.hit1());
                    UserCount++;
                }
                out.print(user.myCards + "<br>" + "<br>");
                out.print("Hit！" + "✕" + UserCount + "回" + "<br>" + "<br>");
            } else if (user.checkSum() == false) {
                out.print(user.myCards + "<br>" + "<br>");
                out.print("Stand！" + "<br>" + "<br>");
            }
            if (user.open() == 21) {
                out.print("合計：「21」(ブラックジャック！)" + "<br>" + "<br>");
            } else if (user.open() > 21) {
                out.print("「...buct！」" + "<br>" + "<br>");
            } else {
                out.print("合計：「" + user.open() + "」" + "<br>" + "<br>");
            }
            out.print("-----------------------------" + "<br>" + "<br>");

            out.print("勝敗は..." + "<br>" + "<br>");

            if (user.open() > 21 && dealer.open() > 21) {
                out.print("☆Draw☆");
            } else if (user.open() == dealer.open()) {
                out.print("☆Draw☆");
            } else if (user.open() > 21) {
                out.print("☆ディーラーの勝ち！☆");
            } else if (dealer.open() > 21) {
                out.print("☆ユーザーの勝ち！☆");
            } else if (dealer.open() > user.open()) {
                out.print("☆ディーラーの勝ち！☆");
            } else {
                out.print("☆ユーザーの勝ち！☆");
            }

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
