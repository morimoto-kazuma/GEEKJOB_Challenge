<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //セッションスタート
    HttpSession hs = request.getSession();
    
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    名前:<%= udd.getName()%><br>
       生年月日:<%= udd.getBirthday()%><br>
       種別:<%= jh.exTypenum(udd.getType())%><br>
       電話番号:<%= udd.getTell()%><br>
       自己紹介:<%= udd.getComment()%><br>
       更新日時:<%= jh.SimpleDate(udd.getNewDate())%><br>
    削除しました。<br>
    
    <%=jh.searchresult()%>
    
    </body>
</html>
