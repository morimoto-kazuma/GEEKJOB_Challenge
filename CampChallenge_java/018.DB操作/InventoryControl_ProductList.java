/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author PCUser
 */
public class InventoryControl_ProductList extends HttpServlet {

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



            request.setCharacterEncoding("UTF-8");
            HttpSession hs_2 = request.getSession();

            hs_2.setAttribute("change_type", request.getParameter("type"));
           
            String change_type = (String) hs_2.getAttribute("change_type");
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

                db_st = db_con.prepareStatement("select * from system where name = ?");

                db_st.setString(1,change_type);         

                db_data = db_st.executeQuery();

                if(db_data.next()){
                   
                     hs_2.setAttribute("change_A",db_data.getString("id"));
                     hs_2.setAttribute("change_B",db_data.getString("name"));
                     hs_2.setAttribute("change_C",db_data.getString("part"));
                     hs_2.setAttribute("change_D",db_data.getString("stock"));
                               
                RequestDispatcher dispatch = request.getRequestDispatcher("InventoryControl_ProductList.jsp");
                dispatch.forward(request, response);
                }else{
                RequestDispatcher dispatch = request.getRequestDispatcher("InventoryControl_ProductList_BackPage.jsp");
                dispatch.forward(request, response);
                }    
                

                db_con.close();

            } catch (SQLException e_sql) {
                out.print("エラーです。お疲れ様です。" + e_sql.toString());
            } catch (Exception e) {
                out.print("エラーですね。お疲れ様です。" + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        out.print(e_con.getMessage());
                    }
                }
            }            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InventoryControl_ProductList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InventoryControl_ProductList at " + request.getContextPath() + "</h1>");
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
