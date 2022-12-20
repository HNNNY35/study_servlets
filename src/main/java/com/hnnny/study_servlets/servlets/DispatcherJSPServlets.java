package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSPServlets")

public class DispatcherJSPServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 히든파라메터의 값에 따라 분기하기
        String hiddenParam = request.getParameter("hiddenParam");
        
        request.setAttribute("firstName", "Haein");
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/search_form.jsp");
        requestDispatcher.forward(request, response);

      
    }
}
