package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckUserLogic;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// jspから送られた値を取得
        String nickName = request.getParameter("nickName");
        String password = request.getParameter("password");
        // userインスタンスを生成しつつ、コントラスタを動かす。
        User user = new User(nickName, password);
        // CheckUserLogicインスタンスを生成。
        CheckUserLogic checkUser = new CheckUserLogic();
        // executeメソッドの処理結果を新たに変数に入れる。入る値はnullかDAOで生成した新たなUserインスタンス。
        User findedUser = checkUser.execute(user);
        // findedUserの処理結果に応じて表示するViewを選定する。
        if (findedUser != null) {
        		// Userインスタンスが入っていれば、結果をリクエストパラメータにセットしmainPageを表示する。
            request.setAttribute("findedUser", findedUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginFail.jsp");
            dispatcher.forward(request, response);
        }
    }
}