<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<% User findedUser = (User) request.getAttribute("findedUser"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>TestApp</title>
    </head>
    <body>
        <div>
            <h3>メインページ</h3>
            <p>ようこそ<strong><%= findedUser.getNickName() %></strong>さん</p>
        </div>
    </body>
</html>