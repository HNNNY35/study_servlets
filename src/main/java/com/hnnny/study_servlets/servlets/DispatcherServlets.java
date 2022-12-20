package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlets")

public class DispatcherServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 히든파라메터의 값에 따라 분기하기
        String hiddenParam = request.getParameter("hiddenParam");

        if("searchFormServlet".equals(hiddenParam)) {
            // /dispatcherServlets?hiddenParam=searchFormServlet
            // sendRedirect로 해당하는 url을 넣어주면 이동(hiddenParam 전달 X)
            response.sendRedirect("/searchFormServlet");
        } else if("createCookieServlets".equals(hiddenParam)) {
            // /dispatcherServlets?hiddenParam=createCookieServlets
            // getRequestDispatcher : url이동 + hiddenParam도 같이 전달
            RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/cookies/createServlets");
            request.setAttribute("firstName", "Haein");
            requestDispatcher.forward(request, response);
            // 추가적으로 파라메터를 리퀘스트에 실어서 보낼 수 있음(리퀘스트가 다 날아감)
        } else {
            // nomarl display
            String message = "DispatcherServlets with Message";
            PrintWriter printWriter =  response.getWriter();
    
            printWriter.println("<html lang='en'>");
            printWriter.println("<head>");
            printWriter.println("<title>"+message+"</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<button>call DispatcherServlets</button>");
            printWriter.println("</form>");
            printWriter.println("</body>");
            printWriter.println("</html>");
    
    
            printWriter.close();

        }
    }
}
