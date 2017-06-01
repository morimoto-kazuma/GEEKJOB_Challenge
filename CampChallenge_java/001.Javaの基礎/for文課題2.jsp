<%-- 
    Document   : challenge3-2
    Created on : 2017/06/01, 13:28:45
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String hajime = "始め";
String saigo = "終わり";
String moji = "A";
String iremono = "";

out.print(hajime+"<br>");

for (int i=0; i < 30;i++){
iremono = iremono+moji;
out.print(iremono);
out.print("<br>");
}
out.print("<br>");
out.print(saigo);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
 
    </body>
</html>
