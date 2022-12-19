package com.hnnny.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.study_servlets.DatasInfor;
import com.hnnny.study_servlets.beans.MemberBean;

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
        MemberBean memberBean = datasInfor.getDataWithMemberBean();

        System.out.println(memberBean.getFirstName() + " " + 
        memberBean.getSecondName() + " "  +memberBean.getHandleName());
        
        HashMap<String, Object> bundlesData =  datasInfor.getBundlesData();
        

        //Display areas
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
        
        MemberBean memberBean2 = (MemberBean) bundlesData.get("dataWithMemberBean");
        
        printwiter.println(memberBean2.getFirstName() + " " + 
        memberBean2.getSecondName() + " "  +memberBean2.getHandleName() + "</div>");

        // printwiter.println("<div class='fs-4'>" + memberBean.getFirstName() + " " + 
        // memberBean.getSecondName() + " "  +memberBean.getHandleName() + "</div>");
        
        printwiter.println("<table class='table'>");
        printwiter.println("<thead>");
        printwiter.println("<tr>");
        printwiter.println("<th scope=>#</th>");
        printwiter.println("<th scope=>First</th>");
        printwiter.println("<th scope=>Last</th>");
        printwiter.println("<th scope=>Handle</th>");
        printwiter.println("</tr>");
        printwiter.println("</thead>");
        printwiter.println("<tbody>");

        ArrayList<MemberBean> dataListWithMemberBean = (ArrayList<MemberBean>) bundlesData.get("getDataListWithMemberBean");
        for(int i=0; i<dataListWithMemberBean.size(); i++){
            MemberBean memberBean03 = dataListWithMemberBean.get(i);
            printwiter.println("                <tr>");
            printwiter.println("                    <th scope=>"+(i+1)+"</th>");

            String handle = memberBean03.getHandleName();
            printwiter.println("                    <td>"+memberBean03.getFirstName()+"</td>");
            printwiter.println("                    <td>"+memberBean03.getSecondName()+"</td>");
            printwiter.println("                    <td>"+handle+"</td>");
            printwiter.println("                </tr>");
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
