package main.java.com.controllers.servlet;

import com.alibaba.fastjson.JSON;
import main.java.com.utils.JSONUtils;
import main.java.com.utils.RSAUtils;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Encryption", urlPatterns = {"/Encryption"})
public class EncryptionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        KeyPair keyPair = RSAUtils.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        request.getSession().setAttribute("_private_key", privateKey);
        Map<String, Object> publicKeyMap = new HashMap<>();
        publicKeyMap.put("publicKey", Base64.encodeBase64String(keyPair.getPublic().getEncoded()));
        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(JSON.toJSONString(publicKeyMap));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append(line);
        } catch (IOException e) {
            System.out.println("" + e);
        }
        Map data = JSONUtils.toObject(sb.toString(), Map.class);
        String encryptedData = data.get("encryptedData").toString();
        PrivateKey privateKey = (PrivateKey) request.getSession().getAttribute("_private_key");
        System.out.println(RSAUtils.decrypt(encryptedData, privateKey));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
