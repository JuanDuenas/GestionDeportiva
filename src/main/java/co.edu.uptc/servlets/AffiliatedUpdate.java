package co.edu.uptc.servlets;

import co.edu.uptc.control.AffiliatedService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/affiliated_update")
public class AffiliatedUpdate extends HttpServlet {

    private AffiliatedService affiliatedService;
    @Override
    public void init() throws ServletException {
        affiliatedService = new AffiliatedService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String dni = req.getParameter("dni");
        System.out.println(dni);
        PrintWriter out = resp.getWriter();
        String data = affiliatedService.getAffiliatedByDni(dni);
        System.out.println("affiliatedUpdate "+data);
        if(!data.equals("")){
            out.println(data);
        }else{
            out.println("");
        }
    }
}
