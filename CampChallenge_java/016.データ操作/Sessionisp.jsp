<%-- 
    Document   : Sessionjsp
    Created on : 2017/07/03, 13:14:20
    Author     : PCUser
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    HttpSession hs = request.getSession();

    hs.setAttribute("name2", request.getParameter("Name"));
    hs.setAttribute("sss2", request.getParameter("sss"));
    hs.setAttribute("radio2", request.getParameter("radio"));
    hs.setAttribute("hobby2", request.getParameter("mulText"));

    String name1 = (String) hs.getAttribute("name2");
    String sss1 = (String) hs.getAttribute("sss2");
    String radio1 = (String) hs.getAttribute("radio2");
    String hobby1 = (String) hs.getAttribute("hobby2");

    String aaa = "";
    String bbb = "";

    if (hs.getAttribute("sss2") != null) {
        if (hs.getAttribute("sss2").equals("man")) {
            aaa = "checked";
        }
        if (hs.getAttribute("sss2").equals("woman")) {
            bbb = "checked";
        }
    }

    radio1 = radio1 == null ? "（radio:未送信）" : radio1;

%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Sessionisp.jsp" method="post">
            ■名前<br>
            <input type="text" name="Name" value=<%
                if (name1 != null) {
                    out.print(name1);
                } else {
                    out.print("");
                }%>>
            <br>
            <br>
            ■性別<br>

            男 
            <input type="radio" name="sss" value="man" <%=aaa%>>
            <br>
            女 
            <input type="radio" name="sss" value="woman"
            <%=bbb%>>
            <br>
            <br>
            
            ■山本 or 森本 or 村本
            <br>
            <label>
                <input type="radio" name="radio" value="yama" <%=radio1.equals("yama") ? "checked" : ""%>>山本
            </label>
            <br>
            <label>
                <input type="radio" name="radio" value="mori"
                 <%=radio1.equals("mori") ? "checked" : ""%>>森本
            </label>
            <br>
            <label>
                <input type="radio" name="radio" value="mura"
                 <%=radio1.equals("mura") ? "checked" : ""%>>村本
            </label>

            <br>
            <br>
            ■趣味<br>
            <textarea name="mulText"><%
                if (hobby1 != null) {
                    out.print(hobby1);
                } else {
                    out.print("");
                }%></textarea>
            <br>
            <br>
            <br>
            <input type="submit" name="btnSubmit">


        </form> 
    </body>
</html>
