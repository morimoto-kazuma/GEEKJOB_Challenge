<%-- 
    Document   : DB_10
    Created on : 2017/07/12, 9:59:28
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();

    hs.setAttribute("select", request.getParameter("Select"));
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ■登録変更フォーム<br><br>
        
        <form action="DB_10_2.jsp" method="post">

            変更するIDを選択して下さい。<select name="Select">
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
