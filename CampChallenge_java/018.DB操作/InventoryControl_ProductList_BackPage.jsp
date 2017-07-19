<%-- 
    Document   : InventoryControl_ProductList_BackPage
    Created on : 2017/07/15, 11:54:45
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
out.print("検索された商品情報はありませんでした。");
out.print("<br>");
out.print("<br>");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <br>
            <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="メインページへ戻る">
            </form>
    </body>
</html>
