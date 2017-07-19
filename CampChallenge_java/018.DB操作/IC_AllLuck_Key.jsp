<%-- 
    Document   : IC_AllLuck_Key
    Created on : 2017/07/15, 17:23:09
    Author     : PCUser
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("UTF-8");

  HttpSession hs_2 = request.getSession();
  
ResultSet db_data_key = (ResultSet) hs_2.getAttribute("db_data_key");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ■キーワード検索結果<br>
        <br>
        --該当商品情報表示--<br>
        <br>
        <%
                    out.print("-------------------------------" + "<br>");
        while (db_data_key.next()) {
                    out.print("商品ID:" + db_data_key.getString("id") + "<br>");
                    out.print("商品名" + db_data_key.getString("name") + "<br>");
                    out.print("部位:" + db_data_key.getString("part") + "<br>");
                    out.print("在庫数:" + db_data_key.getString("stock") + "<br>");
                    out.print("<br>");
                }
                    out.print("-------------------------------" + "<br>");
        %>
        <br>
        <br>
        <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="メインページへ戻る">
            </form>
        <br>
        <form action="IC_AllLuck.jsp" method="post">
            <input type="submit" name="Submit" value="全件表示ページへ戻る">
            </form>
        <br>
    </body>
</html>
