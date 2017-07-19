<%-- 
    Document   : IC_DeleteCheck
    Created on : 2017/07/15, 15:13:16
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
            HttpSession hs_2 = request.getSession();
            
String delete_id = (String) hs_2.getAttribute("delete_id");
String delete_name = (String) hs_2.getAttribute("delete_name");
String delete_part = (String) hs_2.getAttribute("delete_part");
String delete_stock = (String) hs_2.getAttribute("delete_stock");

out.print("検索された商品情報");
out.print("<br>");
out.print("----------------------------------------" + "<br>");
out.print("商品ID:"+ delete_id + "<br>");
out.print("商品名:"+ delete_name + "<br>");
out.print("部位:"+ delete_part + "<br>");
out.print("在庫数:"+ delete_stock + "<br>");
out.print("----------------------------------------" + "<br>");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        上記登録情報を削除します。よろしいですか？
        <br>
        <br>
        <br>
        <br>
        <form action="IC_Delete" method="post">
            <input type="submit" name="Submit" value="削除">
        </form>
        <br>
      <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="やっぱりやめる">
        </form>
    </body>
</html>
