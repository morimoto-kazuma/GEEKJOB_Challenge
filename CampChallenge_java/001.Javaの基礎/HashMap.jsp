<%-- 
    Document   : challenge2-7
    Created on : 2017/06/01, 10:25:38
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page  import="java.util.HashMap" %>
<%   
HashMap<String,String>hako1=new HashMap<String,String>();
HashMap<String,String>hako2=new HashMap<String,String>();
HashMap<String,String>hako3=new HashMap<String,String>();
HashMap<String,String>hako4=new HashMap<String,String>();

hako1.put("1","AAA");
hako2.put("hello","world");
hako3.put("soeda","36650");
hako3.put("soeda","33");
hako4.put("20","20");

out.print(hako1.get("1"));
out.print(hako2.get("hello"));
out.print(hako3.get("soeda"));
out.print(hako4.get("20"));

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
    </body>
</html>
