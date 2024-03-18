package co.edu.uptc.servlets;

import co.edu.uptc.control.EventService;
import co.edu.uptc.model.Affiliated;
import co.edu.uptc.model.Discipline;
import co.edu.uptc.model.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/event_servlet")
public class EventServlet extends HttpServlet {
    private EventService eventService;
    @Override
    public void init() throws ServletException {
        eventService = new EventService();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String data = eventService.getEvent();
        if(!data.equals(null)){
            out.println(data);
        }else{
            out.println("");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String name,description,discipline;
        int podium;
        String descriptionDiscipline = "";
        boolean isGroup = false;

        name = req.getParameter("name");
        description = req.getParameter("description");
        discipline = req.getParameter("discipline");
        podium = Integer.parseInt(req.getParameter("podium"));

        if(discipline.equals("Fútbol")){
            descriptionDiscipline = "Se juega mediante una pelota que se debe desplazar a través del campo con cualquier parte del cuerpo que no sean los brazos o las manos, y mayoritariamente con los pies (de ahí su nombre). El objetivo es introducirla dentro de la portería o arco contrario, acción que se denomina marcar un gol";
            isGroup = true;
        }
        if(discipline.equals("Natación")){
            descriptionDiscipline = "La natación es un deporte que consiste en trasladarse de un lugar al otro en el agua sin que la persona toque el suelo. La natación puede practicarse en piscina o en aguas abiertas.";
        }
        if(discipline.equals("Baloncesto")){
            descriptionDiscipline = "El baloncesto consiste en introducir un balón, que dará punto, en un aro ubicado a 3 metros de altura. El balón puede ser golpeado en cualquier dirección con una o ambas manos, pero nunca con el puño. Un jugador no puede correr con el balón. El jugador debe lanzarlo desde el lugar donde lo toma.";
            isGroup = true;
        }

        Event event = new Event(name,description,new Discipline(discipline,descriptionDiscipline,isGroup),podium);
        PrintWriter out = resp.getWriter();
        if(eventService.inserEvent(event) != null){
            out.println(event);
        }else{
            out.println("");
        }


    }
}
