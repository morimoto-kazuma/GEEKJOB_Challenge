<%-- 
    Document   : DB_12
    Created on : 2017/07/12, 15:42:46
    Author     : PCUser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     ■複合検索フォーム<br><br>
     AND検索の場合は3項目全て記入して下さい。<br>
      OR検索の場合は1項目からで大丈夫です。<br><br>
     
        <form action="DB_12" method="post">
                名前<br>
            <input type="text" name="Name">
            <br><br>
                年齢<br>
            <input type="text" name="Age">
            <br><br>
                生年月日<br>
            <input type="text" name="Birth">
            <br><br>
            AND検索<input type="radio" name="Radio" value="AND"checked><br>
            OR検索<input type="radio" name="Radio" value="OR"><br>


            <input type="submit" name="Submit"value="検索">
        </form>
    </body>
</html>
