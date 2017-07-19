<%-- 
    Document   : InventoryControl_LoginPage
    Created on : 2017/07/13, 17:13:16
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
HttpSession hs_2 = request.getSession();

if(hs_2 != null){

String err = (String)hs_2.getAttribute("err");

if(err == null){
out.print("");
}else{
out.print(err+"<br>"+"<br>");
hs_2.removeAttribute("err");
}
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet"type="text/css"href="./css2.css"media="all"/>-->
        <title>JSP Page</title>
    </head>
    <body>
        ■在庫管理ログインページ<br><br>
        <form action="InventoryControl_LoginPage" method="post">
            user<br>
            <input type="text" name="User" size="10"><br>
            password<br><input type="text" name="Pass" size="8"><br><br>
            <input type="submit" name="Submit" value="ログイン">
        </form>
    </body>
</html>
