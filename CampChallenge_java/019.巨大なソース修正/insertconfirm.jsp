<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>

        <% if (hs.getAttribute("name").equals("")) { %>
        <h1>名前の入力が不完全です</h1>
        <% } else if (hs.getAttribute("year").equals("") || hs.getAttribute("month").equals("") || hs.getAttribute("day").equals("")) { %>
        <h1>生年月日の入力が不完全です。</h1>>
        <% } else if (hs.getAttribute("type") == null) { %>
        <h1>種別の入力が不完全です。</h1>>
        <% } else if (hs.getAttribute("tell").equals("")) {%>
        <h1>電話番号の入力が不完全です。</h1>
        <% } else if (hs.getAttribute("comment").equals("")) {%>
        <h1>自己紹介の入力が不完全です。</h1>
        <% } else {%>
        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year") + "年" + hs.getAttribute("month") + "月" + hs.getAttribute("day") + "日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% }%>
        <form action="insert" method="POST">
            <!--<input type="hidden" name="ab"  value="initialvalue">-->
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
