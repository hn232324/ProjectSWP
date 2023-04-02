<%-- 
    Document   : signupverify
    Created on : Nov 7, 2022, 9:11:12 AM
    Author     : Manh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <span>Chúng tôi đã gửi một mã bảo mật đến Email của bạn.</span>
        <span>Kiểm tra Email để lấy mã</span>
        <form action="signupverify" method="post">
            <input type="text" name="scode"/><br/>
            <input type="submit" value="Xác minh"/>
        </form>
        ${requestScope.mess}
    </body>
</html>
