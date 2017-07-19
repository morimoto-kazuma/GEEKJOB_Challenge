<%-- 
    Document   : IC_Stock_Change
    Created on : 2017/07/15, 13:14:37
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
HttpSession hs_2 = request.getSession();

String chenge_A = (String)hs_2.getAttribute("Canged_id");
String chenge_B = (String)hs_2.getAttribute("Canged_name");
String chenge_C = (String)hs_2.getAttribute("Canged_part");
String chenge_D = (String)hs_2.getAttribute("Canged_stock");

out.print("在庫数変更が完了しました。"+"<br>"+"<br>");
out.print("----------------------------------------" + "<br>");
out.print("商品ID:" + chenge_A+"<br>");
out.print("商品名:" + chenge_B+"<br>");
out.print("部位:" + chenge_C+"<br>");
out.print("在庫数:"+chenge_D+"<br>");
out.print("----------------------------------------" + "<br>");
out.print("<br>");
out.print("<br>");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="メインページへ戻る">
            </form>
        <br>
        
    </body>
</html>
