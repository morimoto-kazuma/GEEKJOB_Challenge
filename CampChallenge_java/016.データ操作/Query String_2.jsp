<%-- 
    Document   : Query String_2
    Created on : 2017/06/26, 15:03:55
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

String A = request.getParameter("簡易素因数分解");
int num = Integer.valueOf(A).intValue();

Integer[] BOX = {2,3,5,7};

out.print("元の値："+num);
out.print("<br>");
out.print("素因数分解の結果:");

for(int i =0;i<3;i++){
while(num % BOX[i]==0){
out.print(BOX[i]+",");
num=num/BOX[i];
}
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
