package com.tahmid.springcrud; /**
 * @author Tahmidul Islam
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "Servlet", value = "/Servlet")
public class WebDemoDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimeZone=UTC";
        String driver = "com.mysql.jdbc.Driver";
        PrintWriter out = response.getWriter();
        try{
            out.println("Connecting to Database");
            Class.forName(driver);
            Connection myConn =
                    DriverManager.getConnection(jdbcURL,user,pass);
            out.println("COnnection Successful");
        }catch(Exception ex){
            out.println(ex);
        }
        finally {
            out.close();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
