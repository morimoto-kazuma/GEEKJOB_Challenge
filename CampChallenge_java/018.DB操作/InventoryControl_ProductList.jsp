<%-- 
    Document   : InventoryControl_ProductList
    Created on : 2017/07/14, 15:03:15
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
HttpSession hs_2 = request.getSession();

String chenge_A = (String)hs_2.getAttribute("change_A");
String chenge_B = (String)hs_2.getAttribute("change_B");
String chenge_C = (String)hs_2.getAttribute("change_C");
String chenge_D = (String)hs_2.getAttribute("change_D");

out.print("検索された商品"+"<br>"+"<br>");
out.print("----------------------------------------" + "<br>");
out.print("商品ID:" +chenge_A+"<br>");
out.print("商品名:"+chenge_B+"<br>");
out.print("部位:" +chenge_C+"<br>");
out.print("在庫数:" + chenge_D+"<br>");
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
        ■在庫数を変更して下さい。
    <form action="IC_Stock_Change" method="post">
       <select name="Select">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select>
            <br>
            <input type="submit" name="Submit" value="確認">
            </form>
            <br>
            <br>
            <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="メインページへ戻る">
            </form>
    </body>
</html>
