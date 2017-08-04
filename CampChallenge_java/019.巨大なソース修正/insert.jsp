<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("userbeans");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%    String name = "";
    String yaer = "0";
    String month = "0";
    String day = "0";
    String tell = "";
    int type = 0;
    String comment = "";

    String a = "";
    String b = "";
    String c = "";
    if (udb != null) {

        name = udb.getName();
        yaer = udb.getYaer();
        month = udb.getMonth();
        day = udb.getDay();
        tell = udb.getTell();
        type = udb.getType();
        comment = udb.getComment();

        if (type != 0) {
            if (type == 1) {
                a = "checked";
            }
            if (type == 2) {
                b = "checked";
            }
            if (type == 3) {
                c = "checked";
            }
        }

    }
    int yaer2 = Integer.parseInt(yaer);
    int month2 = Integer.parseInt(month);
    int day2 = Integer.parseInt(day);
//  }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" value="<%if (name != null) {
                out.print(name);
            }%>">
            <br><br>

            生年月日:　
            <select name="year">
                <option value=""></option>
                <%
                for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"<%if (i == yaer2) {%><%="selected"%><%}%>><%=i%></option>
                <% } %>
            </select>年
            <select name="month">
                <option value=""></option>
                <%
                for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"<%if (i == month2) {%><%="selected"%><%}%>><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value=""></option>
                <%
                for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"<%if (i == day2) {%><%="selected"%><%}%>><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            種別:
            <br>
            <input type="radio" name="type" value="1" <%=a%>>エンジニア<br>
            <input type="radio" name="type" value="2" <%=b%>>営業<br>
            <input type="radio" name="type" value="3" <%=c%>>その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%if (tell != null) {
                out.print(tell);
            }%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%if (comment != null) {
                out.print(comment);
            }%></textarea><br><br>
            <!--セッションから"ac"を取り出し非表示で"ac"の情報をInsertConfirm送る-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
