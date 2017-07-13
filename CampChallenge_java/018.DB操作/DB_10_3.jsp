<%-- 
    Document   : DB_10_3
    Created on : 2017/07/12, 11:11:06
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="DB_10_HTML" method="post">

            ■登録変更ページ<br>
            <br>
            下記フォームより変更してください。<br><br>
            名前 (例：森本 佳寿馬)<br>
            <input type="text" name="Text"><br>
            <br>
            電話番号 (例：090-1111-2222)<br>
            <input type="text" name="Text2"><br>
            <br>
            年齢  <select name="Select">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select>
            <br><br>
            誕生日 (例：1990-09-09)<br>
            <input type="text" name="Text3"><br>
            <br>
            <input type="submit" name="Submit" value="変更">
        </form>
    </body>
</html>
