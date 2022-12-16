package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.study_servlets.DatasInfor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tablesBeanListServlets")
public class TablesBeanListServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DatasInfor datasInfor = new DatasInfor();
        ArrayList<String> tablesListWithString = datasInfor.getTablesListWithString();

        PrintWriter printwiter =  response.getWriter();
        
        HashMap<String, String> searchForm = datasInfor.getSearchFormData();

        printwiter.println("<!DOCTYPE html>");
        printwiter.println("<html lang='en'>");
        printwiter.println("<head>");
        printwiter.println("<meta charset='UTF-8'>");
        printwiter.println("<title>"+searchForm.get("search_key")+"</title>");
        printwiter.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'");
        printwiter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous' />");
        printwiter.println("<link rel='stylesheet' href='./css/images/js/commons.css' />");
        printwiter.println("</head>");

        printwiter.println("<body>");
        printwiter.println("<div class='container'>");
        printwiter.println("<div class='fs-3'>Tables with Bean</div>");
        printwiter.println("<table class='table'>");
        printwiter.println("<thead>");
        printwiter.println("<tr>");
        printwiter.println("<th scope=>#</th>");
        // printwiter.println("<th scope=>First</th>");
        // printwiter.println("<th scope=>Last</th>");
        printwiter.println("<th scope=>Handle</th>");
        printwiter.println("</tr>");
        printwiter.println("</thead>");
        printwiter.println("<tbody>");
        for(int i=0; i<tablesListWithString.size(); i++) {
            printwiter.println("<tr>");
            printwiter.println("<th scope=>"+ (i+1) +"</th>");
            printwiter.println("<td>"+tablesListWithString.get(i)+"</td>");
            printwiter.println("</tr>");
        }
      
        printwiter.println("</tbody>");
        printwiter.println("</table>");

        printwiter.println("</div>");
        printwiter.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printwiter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4' crossorigin='anonymous' ></script>");
        printwiter.println("</body>");
        printwiter.println("</html>");

        printwiter.close();
    }
}
