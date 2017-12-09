package com.jwt.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        
 
        String n = request.getParameter("nombre");
        String p = request.getParameter("autor");
   
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://mysql:3306/lllc", "root", "root");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into LIBRERIA values(?,?)");
            
            ps.setString(1, n);
            ps.setString(2, p);
 
            int i = ps.executeUpdate();
            if (i > 0){
            	
            	response.sendRedirect("bookregistered.jsp");
            }
            
            
        	
            	
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
       
    }
}
