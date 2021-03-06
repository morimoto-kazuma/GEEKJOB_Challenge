<%-- 
    Document   : DB_8.HTML
    Created on : 2017/07/10, 14:38:23
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.sql.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    
    String moji = "";

    if (request.getParameter("form") != null) {
        moji = request.getParameter("form");
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

            db_st = db_con.prepareStatement("select * from profiles where name like ?");
            db_st.setString(1,"%" + moji + "%");

            db_data = db_st.executeQuery();

            while (db_data.next()) {
                out.print("profilesID:" + db_data.getString("profilesID") + "<br>");
                out.print("name" + db_data.getString("name") + "<br>");
                out.print("tell:" + db_data.getString("tell") + "<br>");
                out.print("age:" + db_data.getString("age") + "<br>");
                out.print("birthday:" + db_data.getString("birthday") + "<br>");
            }
            db_con.close();

        } catch (SQLException e_sql) {
            out.print("エラー：" + e_sql.toString());
        } catch (Exception e) {
            out.print("エラー：" + e.toString());
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
        ■検索フォーム<br>
        <form action="DB_8.HTML.jsp" method="post">
            <input type="text" name="form">
            <input type="submit" name="button">
        </form>
    </body>
</html>
