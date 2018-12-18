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

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class RegisterController extends HttpServlet {

    private static final String LOGIN = "/login.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("username");
        String pw = request.getParameter("psword");
        LoginModel user = new LoginModel(un, pw);
        UsersData.getInstance().addNewUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("password", user.getPsword());
        RequestDispatcher view = request.getRequestDispatcher(LOGIN);
        view.include(request, response);
    }
}
