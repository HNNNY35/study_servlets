package com.hnnny.study_servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/formsSelectsServlet")
public class FormsSelectsServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        PrintWriter printwriter = response.getWriter();

        printwriter.println("<html lang='en'>");
        printwriter.println("<head>");
        printwriter.println("<title>Document</title>");
        printwriter.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printwriter.println("rel='stylesheet' integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printwriter.println("crossorigin='anonymous' />");
        printwriter.println("<link rel='stylesheet' href='./css/commons.css' />");
        printwriter.println("</head>");
  
        printwriter.println("<body>");
        printwriter.println("<div class='fs-3'>form selects</div>");
        printwriter.println("<div>");
        printwriter.println("<label for='' class='form-label'>select</label>");
        printwriter.println("<select class='form-select' aria-label=''>");
        printwriter.println("<option selected>Open this select menu</option>");
        printwriter.println("<option value='M01'>One</option>");
        printwriter.println("<option value='M02' selected>Two</option>");
        printwriter.println("<option value='M03'>Three</option>");
        printwriter.println("</select>");
        printwriter.println("</div>");

        printwriter.println("<div>");
        printwriter.println("<label for='' class='form-label'>select multiple</label>");
        printwriter.println("<select class='form-select' aria-label='' multiple>");
        printwriter.println("<option value='M01'>One</option>");
        printwriter.println("<option value='M02' selected>Two</option>");
        printwriter.println("<option value='M03'>Three</option>");
        printwriter.println("<option value='M04' selected>Four</option>");
        printwriter.println("</select>");
        printwriter.println("</div>");

        printwriter.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printwriter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printwriter.println("crossorigin='anonymous'></script>");
        printwriter.println("</body>");
        printwriter.println("</html>");

        printwriter.close();
    }
}
