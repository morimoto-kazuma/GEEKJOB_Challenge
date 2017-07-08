<%-- 
    Document   : DB_2
    Created on : 2017/07/08, 16:47:45
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
Connection db_con = null;
PreparedStatement db_st = null;
PreparedStatement db_st2 = null;
String db_data = null;
ResultSet db_data2 = null;


try {
    Class.forName("com.mysql.jdbc.Driver").newInstance();  
 db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "MorimotoKazuma", "mzmzm2323");

db_st = db_con.prepareStatement("INSERT INTO profiles (profileID,name,tell,age,birthday) VALUES (3,'森本 佳寿馬','090-1111-1111',26,'1990-09-09');");
db_st2 = db_con.prepareStatement("select * from profiles where age = ?");

db_st2.setInt(1, 26);

db_st.executeUpdate();
db_data2 = db_st2.executeQuery();
while(db_data2.next()){
  out.print("名前：" + db_data2.getString("name") + "" + "<br>");
}

db_data2.close();
db_st.close();
db_st2.close();
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
