package co.edu.uptc.servlets;

import co.edu.uptc.control.AffiliatedService;
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

@WebServlet("/update_servlet")
public class UpdateServlet extends HttpServlet {
private AffiliatedService affiliatedService;
    @Override
    public void init() throws ServletException {
        affiliatedService = new AffiliatedService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String name,lastName,dni;
        String age,event;
        int podium = Integer.parseInt(req.getParameter("podium"));

        name = req.getParameter("name");
        lastName = req.getParameter("lastName");
        dni = req.getParameter("dni");
        age = req.getParameter("age");
        event = req.getParameter("event");

        Event e = new Event();
        if(event.equals("1")){
            e = new Event("Torneo Escolar de Futbol","Este torneo se lleva a cabo a nivel local, regional e incluso nacional, brindando a los jóvenes futbolistas la oportunidad de mostrar su talento, mejorar sus habilidades y establecer vínculos con jugadores de otras instituciones educativas",new Discipline("Futbol","Se juega mediante una pelota que se debe desplazar a través del campo con cualquier parte del cuerpo que no sean los brazos o las manos, y mayoritariamente con los pies (de ahí su nombre). El objetivo es introducirla dentro de la portería o arco contrario, acción que se denomina marcar un gol",true),podium);
        }
        if(event.equals("2")){
            e = new Event("Challenge Basketball Tournament","Este torneo se llevará a cabo en Hatillo, con la participación de 80 equipos de 50 escuelas públicas y privadas del país",new Discipline("Baloncesto","El baloncesto consiste en introducir un balón, que dará punto, en un aro ubicado a 3 metros de altura. El balón puede ser golpeado en cualquier dirección con una o ambas manos, pero nunca con el puño. Un jugador no puede correr con el balón. El jugador debe lanzarlo desde el lugar donde lo toma.",true),podium);
        }
        if(event.equals("3")){
            e = new Event("Torneo Escolar de Natación UNAB","Este torneo se llevó a cabo en la Universidad Andrés Bello (UNAB), sede Viña del Mar, en conjunto con ADECOP",new Discipline("Natacion","La natación es un deporte que consiste en trasladarse de un lugar al otro en el agua sin que la persona toque el suelo. La natación puede practicarse en piscina o en aguas abiertas.",false),podium);
        }
        if(event.equals("4")){
            e = new Event("Torneo Buzzer Beater","Este es un torneo de baloncesto escolar que se lleva a cabo en Puerto Rico.",new Discipline("Baloncesto","El baloncesto consiste en introducir un balón, que dará punto, en un aro ubicado a 3 metros de altura. El balón puede ser golpeado en cualquier dirección con una o ambas manos, pero nunca con el puño. Un jugador no puede correr con el balón. El jugador debe lanzarlo desde el lugar donde lo toma.",true),podium);
        }
        if(event.equals("5")){
            e = new Event("Copa Atletismo Escolar","Este torneo fue organizado y auspiciado por Servisport y apoyado por la Federación Atlética de Chile.",new Discipline("Atletismo","El atletismo es un deporte de competición, que se practica en equipo o individual. Consiste en superar el rendimiento del contrincante, ya sea en velocidad, distancia, altura o resistencia",false),podium);
        }

        Affiliated affiliated = new Affiliated(name,lastName,dni,Integer.parseInt(age));
        PrintWriter out = resp.getWriter();
        e.setId(affiliated.getDni());
        affiliated.setEvent(e);
        if(!affiliatedService.updateAffiliated(dni,affiliated).equals(null)){
            EventService es = new EventService();
            System.out.println(affiliated.getEvent().toString());
            es.updateEvent(dni,affiliated.getEvent());
            out.println(affiliated);
        }else{
            out.println("");
        }
    }
}
