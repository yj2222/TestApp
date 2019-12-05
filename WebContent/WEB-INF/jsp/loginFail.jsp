<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>TestApp</title>
    </head>
    <body>
        <div>
            <h3>Login</h3>
            <p style="color:red;">入力に誤りがあります。</p>
            <form action="./LoginServlet" method="post">
                <p>・ニックネーム:</p>
                <input type="text" name="nickName">
                <p>・パスワード:</p>
                <input type="password" name="password">
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>