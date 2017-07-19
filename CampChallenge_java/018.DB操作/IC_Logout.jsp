<%-- 
    Document   : IC_Logout
    Created on : 2017/07/15, 15:02:30
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
HttpSession hs_2 = request.getSession();

hs_2.invalidate();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ログアウトしました。
        <br><br><br><br>
        ログインページへ戻る場合はこちら
        <br>
        <form action="InventoryControl_LoginPage.jsp" method="post">
            <input type="submit" name="Submit" value="戻る">
        </form>
    </body>
</html>
