package main.java.com.controllers.servlet;

import main.java.com.utils.RSAUtils;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Encryption", urlPatterns = {"/Encryption"})
public class EncryptionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("encryption-parameters");
        KeyPair keyPair = RSAUtils.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        request.getSession().setAttribute("_private_key", privateKey);

        Map<String, Object> publicKeyMap = new HashMap<>();
        publicKeyMap.put("publicKey", Base64.encodeBase64String(keyPair.getPublic().getEncoded()));
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
