/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PCUser
 */
public class DB_12 extends HttpServlet {

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

            HttpSession hs = request.getSession();

            hs.setAttribute("name", request.getParameter("Name"));
            hs.setAttribute("age", request.getParameter("Age"));
            hs.setAttribute("birth", request.getParameter("Birth"));
            hs.setAttribute("radio", request.getParameter("Radio"));

            String key_name = (String) hs.getAttribute("name");
            String key_age = (String) hs.getAttribute("age");
            String key_birth = (String) hs.getAttribute("birth");
            String key_radio = (String) hs.getAttribute("radio");

//            int A = Integer.parseInt(key_age);
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

                if (key_radio.equals("AND")) {
                    db_st = db_con.prepareStatement("select * from profiles where name like ? and age=? and birthday like ?");

                    db_st.setString(1, "%" + key_name + "%");
                    db_st.setString(2, key_age);
                    db_st.setString(3, "%" + key_birth + "%");

                } else if (key_radio.equals("OR")) {
                    db_st = db_con.prepareStatement("select * from profiles where name like ? or age=? or birthday like ?");
                    db_st.setString(1, "%" + key_name + "%");
                    db_st.setString(2, key_age);
                    db_st.setString(3, "%" + key_birth + "%");
                }

                db_data = db_st.executeQuery();

                out.print("■検索結果ページ" + "<br>" + "<br>");
                out.print("↓検索された登録情報↓" + "<br>" + "<br>");

                while (db_data.next()) {
                    out.print("-------------------------------" + "<br>");
                    out.print("profilesID:" + db_data.getString("profilesID") + "<br>");
                    out.print("name" + db_data.getString("name") + "<br>");
                    out.print("tell:" + db_data.getString("tell") + "<br>");
                    out.print("age:" + db_data.getString("age") + "<br>");
                    out.print("birthday:" + db_data.getString("birthday") + "<br>");
                    out.print("-------------------------------" + "<br>");
                }
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
            out.println("<title>Servlet DB_10_HTML</title>");
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
