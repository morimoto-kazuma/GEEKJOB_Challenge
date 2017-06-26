<%-- 
    Document   : Challenge5_1_2
    Created on : 2017/06/24, 14:49:13
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

out.print(request.getParameter("txtName"));
out.print(request.getParameter("rdoSample"));
out.print(request.getParameter("mulText"));

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
