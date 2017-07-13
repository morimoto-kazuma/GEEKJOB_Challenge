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
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PCUser
 */
public class DB_10_HTML extends HttpServlet {

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

            String check = (String) hs.getAttribute("select");//ID
            String name = request.getParameter("Text");//名前
            String tell = request.getParameter("Text2");//電話番号
            String age = request.getParameter("Select");//年齢
            String birthday = request.getParameter("Text3");//誕生日

            if (check != null) {

                int A = Integer.parseInt(age);

                int num = Integer.parseInt(check);

                Connection db_con = null;
                PreparedStatement db_st = null;
                PreparedStatement db_st2 = null;
                ResultSet db_data = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

                    db_st2 = db_con.prepareStatement("update profiles set name=?, tell=?, age=?,birthday=? where profilesID = ?");
                    db_st2.setString(1, name);
                    db_st2.setString(2, tell);
                    db_st2.setInt(3, A);
                    db_st2.setString(4, birthday);
                    db_st2.setInt(5, num);

                    db_st = db_con.prepareStatement("select * from profiles where profilesID = ?");
                    db_st.setInt(1, num);

                    db_st2.executeUpdate();
                    db_data = db_st.executeQuery();

                    while (db_data.next()) {
                        out.print("登録変更が完了しました。" + "<br>" + "<br>");
                        out.print("↓変更後の登録情報↓" + "<br>" + "<br>");
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
