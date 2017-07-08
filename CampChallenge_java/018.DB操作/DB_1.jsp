<%-- 
    Document   : DB_1
    Created on : 2017/07/08, 15:32:42
    Author     : PCUser
--%>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Connection db_con = null;
PreparedStatement db_st = null;
ResultSet db_data = null;

try {
    Class.forName("com.mysql.jdbc.Driver").newInstance();  
 db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");
//ageが33のデータを取得
db_st = db_con.prepareStatement("select * from user where age = ?");
db_st.setInt(1, 24);

db_data = db_st.executeQuery();
while(db_data.next()){
  out.print("名前：" + db_data.getString("name") + "" + "<br>");
}

db_data.close();
db_st.close();
db_con.close();

}
catch (SQLException e_sql) {
    out.print("EMERGENCY!EMERGENCY!EMERGENCY!:"+ e_sql.toString());
  }catch (Exception e) {
    out.print("EMERGENCY!EMERGENCY!EMERGENCY!:"+ e.toString());
  }finally{
if (db_con != null){
  try {
    db_con.close();
  } catch (Exception e_con) {
      System.out.println(e_con.getMessage());
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
