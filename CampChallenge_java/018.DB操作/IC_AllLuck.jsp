<%-- 
    Document   : IC_AllLuck
    Created on : 2017/07/15, 14:28:48
    Author     : PCUser
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    HttpSession hs_2 = request.getSession();

    ResultSet db_data = (ResultSet) hs_2.getAttribute("all_data");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ■商品在庫確認ページ<br>
        <br>
        <br>
        キーワードで商品情報を検索する場合はこちらのフォームに入力してください。<br>
        <br>
        <form action="IC_AllLuck_Key" method="post">
            商品ID
            <select name="id_KEY">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select><br>
            商品名<br>
            <input type="text" name="name_kEY">
            <br>
            部位<br>
            <input type="text" name="part_KEY">
            <br>
            在庫数<br>
            <select name="stock_KEY">
                <%
                    for (int i = 0; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select>
            <br><br>
            <input type="submit" name="Submit" value="検索">
            <br>
            <br>
        </form>
        <br>
        <form action="IC_AllLuck_under" method="post">
            こちらから選んだ在庫数以下の商品のみ検索<br>
            <select name="stock_Under">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select><br>
            <br>
            <input type="submit" name="Submit" value="検索">
            <br>
        </form>
            
        <%
            out.print("<br>");
            out.print("<br>");
            out.print("--商品情報全件表示--");
            out.print("<br>");
            out.print("----------------------------------------" + "<br>");

            while (db_data.next()) {
                out.print("商品ID:" + db_data.getString("id") + "<br>");
                out.print("商品名:" + db_data.getString("name") + "<br>");
                out.print("部位:" + db_data.getString("part") + "<br>");
                out.print("在庫数:" + db_data.getString("stock") + "<br>");
                out.print("<br>");
            }
            out.print("----------------------------------------" + "<br>");
        %>
        <br>
        <br>
        <br>
        <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="メインページへ戻る">
        </form>
    </body>
</html>
