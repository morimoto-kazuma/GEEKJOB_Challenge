<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    //JumsHelperのインスタンス生成
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    //セッションからUserDataDAOでArrayListへ格納したUserDataDTOの情報を
    //取り出しArrayListのUserDataDTO型の変数hakoへ代入
    ArrayList<UserDataDTO> hako = (ArrayList)hs.getAttribute("resultsearch");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <!--拡張for文を利用しhakoからUserDataDTO型の変数uddへ
            1つづつ取り出し表示-->
                <% for(UserDataDTO udd : hako){ %>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <!--種別が文字化されたものが返ってくるようにexTypenumの戻り値利用-->
                <td><%= jh.exTypenum(udd.getType())%></td>
                <td><%= jh.SimpleDate(udd.getNewDate())%></td>
            </tr>
                <br>
                <%}%>
        </table>
      
    </body>
    <%=jh.home()%>
</html>
