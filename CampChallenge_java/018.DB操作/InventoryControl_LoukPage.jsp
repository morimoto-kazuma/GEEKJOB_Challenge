<%-- 
    Document   : InventoryControl_LoukPage
    Created on : 2017/07/14, 11:03:38
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    HttpSession hs_2 = request.getSession();

    String data = (String) hs_2.getAttribute("Hello");
    String name = "不正ログイン。";
    

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if (data != null) {
                out.print("ようこそ！"+data+"さん");
            } else {
                out.print(name);
            }%>
            <br><br>
            ■メインページ
            <br><br><br>
        ■商品在庫一覧の場合はこちら
        <br>
        <form action="IC_AllLuck" method="post">
            <input type="submit" name="Submit" value="商品一覧ページ">
        </form>
        <br>
        ■新規商品登録<br>
        商品登録する場合はこちらのフォームからご入力ください。
        <br><br>
        <form action="InventoryControl_LoukPage" method="post">
            商品名<br>
            <input type="text" name="name">
            <br>
            部位<br>
            <input type="text" name="part">
            <br>
            在庫数<br>
            <select name="stock">
                <%
                    for (int i = 1; i <= 100; i++) {
                %> <option value=<%=i%>><%=i%></option> <%
                    }
                %>
            </select>
            <br><br>
            <input type="submit" name="Submit" value="登録">
            <br>
        </form>
        <br>
        ■在庫数変更
        <br>
        <form action="InventoryControl_ProductList" method="post">
            在庫変更する商品名を入力してください。
            <br><br>
            <input type="text" name="type">
            <br><br>
            <input type="submit" name="Submit" value="確認">
        </form>      
        <br>
        ■商品情報削除
        <br>
        削除する商品名を入力してください。
        <br>
        <br>
        <form action="IC_DeleteCheck" method="post">
        <input type="text" name="Delete_name">
            <br><br>
            <input type="submit" name="Submit" value="確認">
            </form> 
        <br><br><br>
        <form action="IC_Logout.jsp" method="post">
            <input type="submit" name="Submit" value="ログアウト">
        </form>
    </body>
</html>
