package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 파라메터가 있는 아래 주소로 들어가야 세션 생성 => JSESSIONID가 request에 들어감
// /session/createServlets?username=hnnny&password=1234
// 받아서 로그인 한 상태면 세션 만들고 로그인 안된 상태면 세션 만들지 X
@WebServlet(urlPatterns = "/session/createServlets")
public class CreateSessionServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Create Session Servlets</div>");
        
        // login
        if(username.equals("hnnny") && password.equals("1234")) {
            // getSession : 제이세션에 세팅되어 있는 username과 password를 가져옴
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            printWriter.println("<div>"+username+", "+password+"</div>");
            
        } else {
            printWriter.println("<div>Faild</div>");
        }


        printWriter.close();
    }
}
