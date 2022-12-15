package com.hnnny.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/searchFormServlet")
public class SearchFormServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printwriter = response.getWriter();
        String title = "Search";

        printwriter.print("<html lang='en'>");

        printwriter.print("<head>");
        printwriter.print("<title>"+title+"</title>");
        printwriter.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'");
        printwriter.print("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'/>");
        printwriter.print("<link rel='stylesheet' href='./css/commons.css' />");
        printwriter.print("</head>");

        printwriter.print("<body>");
        printwriter.print("<form action=''>");
        printwriter.print("<div class='container'>");
        printwriter.print("<div class='fs-3'>Search Form</div>");
        printwriter.print("<div>");
        printwriter.print("<label for='' class='form-label'>Search with Name</label>");
        printwriter.print("<input type='text' class='form-control' placeholder='Input Name!' name='' id='' />");
        printwriter.print("</div>");
        printwriter.print("</div>");
        printwriter.print("</form>");

        printwriter.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printwriter.print("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printwriter.print("crossorigin='anonymous' ></script>");
        printwriter.print("</body>");
        printwriter.print("</html>");
    
        printwriter.close();
    }
    
}
