<%-- 
    Document   : InventoryControl_newProduct
    Created on : 2017/07/14, 17:32:50
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    HttpSession hs_2 = request.getSession();

    String AAA = (String) hs_2.getAttribute("AAA");
    String BBB = (String) hs_2.getAttribute("BBB");
    String CCC = (String) hs_2.getAttribute("CCC");
    String DDD = (String) hs_2.getAttribute("DDD");
    
    
        out.print("登録が完了いたしました。" + "<br>");
        out.print("<br>");
        out.print("<br>");
        out.print("新規で登録情報された商品情報" + "<br>");
        out.print("----------------------------------------" + "<br>");
        out.print(AAA);
        out.print(BBB);
        out.print(CCC);
        out.print(DDD);
        out.print("----------------------------------------" + "<br>");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="InventoryControl_LoukPage.jsp" method="post">
            <input type="submit" name="Submit" value="メインページへ戻る">
            </form>
        <br>
        
    </body>
</html>
