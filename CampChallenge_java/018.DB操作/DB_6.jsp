<%-- 
    Document   : DB_6
    Created on : 2017/07/10, 13:46:24
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    
Connection db_con = null;
PreparedStatement db_st = null;
ResultSet db_data = null;
   try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","MorimotoKazuma","mzmzm2323");

db_st = db_con.prepareStatement("delete from profiles where profilesID = ?");
db_st.setInt(1, 4);

db_st.executeUpdate();

//db_data.close();
db_st.close();
db_con.close();
    
    }catch(SQLException e_sql){
    out.print("エラー：" + e_sql.toString());
    }catch(Exception e){
    out.print("エラー："+e.toString());
    }finally{
    if(db_con!= null){
    try{
    db_con.close();
    }catch(Exception e_con){
    out.print(e_con.getMessage());
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
    </body>
</html>
