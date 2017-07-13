<%-- 
    Document   : DB_11
    Created on : 2017/07/12, 15:21:26
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     ■登録削除フォーム<br><br>
        <form action="DB_11_2.jsp" method="post">

            削除するIDを選択して下さい。<select name="Select">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select>
            <br><br>


            <input type="submit" name="Submit"value="確認">
        </form>
    </body>
</html>
