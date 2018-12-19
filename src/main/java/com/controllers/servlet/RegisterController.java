package main.java.com.controllers.servlet;

import main.java.com.dao.UsersData;
import main.java.com.model.LoginModel;
import main.java.com.utils.RSAUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.PrivateKey;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class RegisterController extends HttpServlet {

    private static final String LOGIN = "/login.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("encr_usnm");
        String pw = request.getParameter("encr_psword");
        PrivateKey privateKey = (PrivateKey) request.getSession().getAttribute("_private_key");
        LoginModel loginModel = new LoginModel(
                RSAUtils.decrypt(un, privateKey),
                RSAUtils.decrypt(pw, privateKey));
        UsersData.getInstance().addNewUser(loginModel);
        HttpSession session = request.getSession();
        session.setAttribute("username", loginModel.getUsername());
        session.setAttribute("password", loginModel.getPsword());
        RequestDispatcher view = request.getRequestDispatcher(LOGIN);
        view.forward(request, response);
    }
}
