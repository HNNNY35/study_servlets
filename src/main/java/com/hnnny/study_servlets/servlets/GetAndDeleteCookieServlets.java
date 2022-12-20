package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/getAndDeleteServlets")
public class GetAndDeleteCookieServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        
        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Get and Delete Cookie Servlets</div>");
        
        // get cookie
        Cookie cookies[] = request.getCookies();
        for(Cookie cookie : cookies) {
            String name = cookie.getName();   // 키
            String value = cookie.getValue();  // 값
            printWriter.println("<div>Cookie Name : " + name + "</div>");
            printWriter.println("<div>Cookie Value : " + value + "</div>");
            
            // delete cookie
            if(name.equals("secondName")) {
                // setMaxAge가 0이면 더이상 사용X => 소멸
                cookie.setMaxAge(0);

                // 삭제한 걸 보내야함
                response.addCookie(cookie);
            }
        }
        printWriter.close();
    }
}
