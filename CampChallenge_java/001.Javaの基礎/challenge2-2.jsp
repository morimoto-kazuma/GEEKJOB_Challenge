<%-- 
    Document   : challenge2-2
    Created on : 2017/05/31, 10:23:35
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    {final int besu=100;
    int num=10;
    
    int tasu =besu+num;
    out.print(tasu);
    out.print("<br>");
    
    int hiku =besu-num;
    out.print(hiku);
    out.print("<br>");
    
    int kakeru =besu*num;
    out.print(kakeru);
    out.print("<br>");
    
    int waru =besu/num;
    out.print(waru);
    out.print("<br>");
    
    int amari =besu%9;
    out.print(amari);
    out.print("<br>");
    }
    {
        int num1=5;
        int num2=5;
        int num3=5;
        int num4=5;
        
        out.print(++num1);out.print("<br>");
        out.print(num2++);out.print("<br>");
        out.print(--num3);out.print("<br>");
        out.print(num4--);out.print("<br>");
    }
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
