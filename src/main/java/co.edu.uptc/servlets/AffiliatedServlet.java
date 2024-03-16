package co.edu.uptc.servlets;

import java.io.*;

import co.edu.uptc.control.AffiliatedService;
import co.edu.uptc.model.Affiliated;
import co.edu.uptc.persistence.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/affiliated_servlet")
public class AffiliatedServlet extends HttpServlet {
    private AffiliatedService affiliatedService;

    public void init() {
        affiliatedService = new AffiliatedService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String name,lastName,dni;
        String age;

        name = req.getParameter("name");
        lastName = req.getParameter("lastName");
        dni = req.getParameter("dni");
        age = req.getParameter("age");

        Affiliated affiliated = new Affiliated(name,lastName,dni,Integer.parseInt(age));
        PrintWriter out = resp.getWriter();

        if(affiliatedService.insertAffiliated(affiliated) != null){
            System.out.println("good");
            out.println(affiliated);
        }else{
            out.println("");
            System.out.println("bad");
        }
    }

    public void destroy() {
    }
}