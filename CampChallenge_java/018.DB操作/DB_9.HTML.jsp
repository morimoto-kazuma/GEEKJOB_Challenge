<%-- 
    Document   : DB_9.HTML
    Created on : 2017/07/10, 16:00:23
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ■新規登録フォーム<br><br>
        <form action="HTML" method="post">

            名前 (例：森本 佳寿馬)<br>
            <input type="text" name="form1"><br>
            <br>
            電話番号 (例：090-1111-2222)<br>
            <input type="text" name="form2"><br>
            <br>
            年齢  <select name="form3">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                }
                %>
            </select>
            <br><br>
            誕生日 (例：1990-09-09)<br>
            <input type="text" name="form4"><br>
            <br>
            <input type="submit" name="button">
        </form>
    </body>
</html>
