<%-- 
    Document   : DB_10_2
    Created on : 2017/07/12, 11:02:19
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    request.setCharacterEncoding("UTF-8");

    HttpSession hs = request.getSession();

    hs.setAttribute("select", request.getParameter("Select"));
    String file = (request.getParameter("Radio"));
    String check = (String) hs.getAttribute("select");

    if (check != null) {

        int num = Integer.parseInt(check);

        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

            db_st = db_con.prepareStatement("select * from profiles where profilesID = ?");
            db_st.setInt(1, num);
            db_data = db_st.executeQuery();

            while (db_data.next()) {
                out.print("■登録情報" + "<br>" + "<br>");
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
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        登録情報に間違いございませんか？<br><br>
        <form action="DB_10_3.jsp" method="post">
            <input type="submit" name="Submit" value="はい">
        </form>
        <form action="DB_10.jsp" method="post">
            <input type="submit" name="Submit" value="いいえ">
        </form>
    </body>
</html>
