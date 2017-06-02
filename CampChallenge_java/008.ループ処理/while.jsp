<%-- 
    Document   : challenge3-3
    Created on : 2017/06/02, 10:20:05
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%


int key = 1000;
int count = 0;
while(key>100) {
    key = key / 2;
    count++;
}

out.print(count + "回割って100以下になりました！");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
