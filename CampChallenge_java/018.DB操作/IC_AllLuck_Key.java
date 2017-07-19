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
public class IC_AllLuck_Key extends HttpServlet {

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

            hs_2.setAttribute("id_key", request.getParameter("id_KEY"));
            hs_2.setAttribute("name_key", request.getParameter("name_KEY"));
            hs_2.setAttribute("part_key", request.getParameter("part_KEY"));
            hs_2.setAttribute("stock_key", request.getParameter("stock_KEY"));

            String id_key = (String) hs_2.getAttribute("id_key");
            String name_key = (String) hs_2.getAttribute("name_key");
            String part_key = (String) hs_2.getAttribute("part_key");
            String stock_key = (String) hs_2.getAttribute("stock_key");

//            int A = Integer.parseInt(key_age);
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");
 
                
                if(name_key !=null){
                name_key = "abc";
                }
                if(part_key.equals("")){
                part_key = "abc";
                }
                if(stock_key.equals("0")){
                stock_key = "abc";
                }
                
                
                    db_st = db_con.prepareStatement("select * from system where id=? or name like ? or part like ? or stock=?");
                    db_st.setString(1, id_key);
                    db_st.setString(2, "%" + name_key + "%");
                    db_st.setString(3, "%" + part_key + "%");
                    db_st.setString(4, stock_key);
                

                db_data = db_st.executeQuery();

                hs_2.setAttribute("db_data_key",db_data);
                
                RequestDispatcher dispatch = request.getRequestDispatcher("IC_AllLuck_Key.jsp");
                dispatch.forward(request, response);
                
                db_con.close();
            } catch (SQLException e_sql) {
                out.print("エラー：記入漏れがあります" + e_sql.toString());
            } catch (Exception e) {
                out.print("エラー：記入漏れがあります" + e.toString());
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
            out.println("<title>Servlet IC_AllLuck_Key</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IC_AllLuck_Key at " + request.getContextPath() + "</h1>");
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
