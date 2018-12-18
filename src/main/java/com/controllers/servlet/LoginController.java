package main.java.com.controllers.servlet;

import main.java.com.dao.UsersData;
import main.java.com.model.LoginModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    private static final String REGISTRATION = "/registration.jsp";
    private static final String ENCRYPTIONJSP = "/encryption.jsp";
    private static final String LOGIN = "/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(LOGIN);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("username");
        String pw = request.getParameter("psword");
        LoginModel loginModel = new LoginModel(un, pw);
        loginModel = UsersData.getInstance().getLogin(loginModel);
        RequestDispatcher view;
        if (Objects.isNull(loginModel)) {
            view = request.getRequestDispatcher(REGISTRATION);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", loginModel.getUsername());
            session.setAttribute("password", loginModel.getPsword());
            view = request.getRequestDispatcher(ENCRYPTIONJSP);
        }
        view.forward(request, response);
    }
}
