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
public class IC_Stock_Change extends HttpServlet {

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

            hs_2.setAttribute("sc", request.getParameter("Select"));
            String chenge_name = (String)hs_2.getAttribute("change_B");
            String sc = (String) hs_2.getAttribute("sc");

            Connection db_con = null;
            PreparedStatement db_st = null;
            PreparedStatement db_st2 = null;
            ResultSet db_data = null;
            

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

                db_st = db_con.prepareStatement("update system set stock = ? where name = ?");
                
                db_st2 = db_con.prepareStatement("select * from system where name = ?");
                
                
                db_st.setString(1,sc);
                db_st.setString(2,chenge_name);
                
                db_st2.setString(1,chenge_name);     
                
                db_st.executeUpdate();
                db_data = db_st2.executeQuery();

                while (db_data.next()) {
                hs_2.setAttribute("Canged_id",db_data.getString("id"));
                hs_2.setAttribute("Canged_name",db_data.getString("name"));
                hs_2.setAttribute("Canged_part",db_data.getString("part"));
                hs_2.setAttribute("Canged_stock",db_data.getString("stock"));
                }

                RequestDispatcher dispatch = request.getRequestDispatcher("IC_Stock_Change.jsp");
                dispatch.forward(request, response);

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
            out.println("<title>Servlet IC_Stock_Change</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IC_Stock_Change at " + request.getContextPath() + "</h1>");
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
