package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import com.hnnny.study_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets extends HttpServlet {
    /* (non-Javadoc)
     * @see jakarta.servlet.http.HttpServlet#doGet(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse)
     */
    @Override
    // a태그로 get 방식으로 받기 때문에
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getParameter는 웹브라우저에서 들어오는 parameter를 사용하기 위함
        // getAttribute는 서블렛과 jsp 사이에서 사용하기 좋음 
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB
        PollWithDB pollWithDB = new PollWithDB();
        HashMap<String, Object> question = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // output with html
        request.setAttribute("question", question);

        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);

    }
}
