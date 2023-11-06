package com.server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/xu-ly")
public class HelloServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/htm");
        String userName = request.getParameter("username");
        String url = "Success.jsp";
        if(!userName.equals("minhquanpro")) {
            request.setAttribute("error", "Bạn đã nhập sai tài khoản");
            url = "loginForm.jsp";
        }

        RequestDispatcher rq = request.getRequestDispatcher(url);
        try {
            rq.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
