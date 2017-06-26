<%-- 
    Document   : QueryString_1
    Created on : 2017/06/26, 11:08:48
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    String type = request.getParameter("type");
    String total = request.getParameter("total");
    String count = request.getParameter("count");

    //文字列の型を数字型へ変換
    int A = Integer.valueOf(total).intValue();
    int B = Integer.valueOf(count).intValue();

    Integer price = A / B;

    out.print("1つ" + price + "円です！");
    out.print("<br>");
    out.print("種別は「");

    //文字列比較する際は  変数1.equals(変数2)
    if (type.equals("1")) {
        out.print("雑貨");
    } else if (type.equals("2")) {
        out.print("生鮮食品");
    } else if (type.equals("3")) {
        out.print("その他");
    } else {
        out.print("未入力");
    }
    out.print("」です！");
    out.print("<br>");

    out.print("今回のポイントは「");
    if (A >= 3000) {
        double AA = A * 0.04;
        out.print((int) AA);
    } else if (A >= 5000) {
        double BB = A * 0.05;
        out.print((int) BB);
    }
    out.print("P」です！");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
