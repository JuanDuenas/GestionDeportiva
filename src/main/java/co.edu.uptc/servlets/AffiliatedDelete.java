package co.edu.uptc.servlets;

import co.edu.uptc.control.AffiliatedService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/affiliated_delete")
public class AffiliatedDelete extends HttpServlet {
    AffiliatedService affiliatedService;
    @Override
    public void init() throws ServletException {
        affiliatedService = new AffiliatedService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String dni;
        dni = req.getParameter("dni");
        System.out.println("dni: "+dni);
        affiliatedService.deleteAffiliated(dni);
        PrintWriter out = resp.getWriter();
        out.println(affiliatedService.deleteAffiliated(dni));
    }
}
