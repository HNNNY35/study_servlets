package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.study_servlets.dao.SimpleWithDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple/WithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");

        // biz with DB
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        ArrayList<HashMap> bundle_list = simpleWithDB.getList();

        
        // display
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<div>SimpleWithDBServlets</div>");
        
        // buncle_list 묶음을 역으로 풀어서 웹에 출력하기
        for(int i = 0; i <bundle_list.size(); i++) {
            // bundle_list에 들어있는 것 = bundle => 자료형 HashMap<String,Object>
            HashMap<String,Object> bundle = bundle_list.get(i);
            
            // bundle에 들어있는 것 = quesiton, exmaple_list
            // question 자료형 = HashMap<String, Object>
            HashMap<String, Object> question = (HashMap<String, Object>) bundle.get("question");
            int orders = (int) question.get("ORDERS");
            String questions = (String) question.get("QUESTIONS");
            String questions_uid = (String) question.get("QUESTIONS_UID");
            
            printWriter.println("<div>" + orders + ". " + questions + "<input type='hidden' value='" + questions_uid + "'></div>");

        }  

        printWriter.close();
    }
}
