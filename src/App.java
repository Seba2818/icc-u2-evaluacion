import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import controllers.TicketController;
import models.TicketSoporte;

public class App {
    public static void main(String[] args) throws Exception {
        
        List <TicketSoporte> tickets = new ArrayList<>();

        tickets.add(new TicketSoporte("TK-104", "Ana Torres", 5));
        tickets.add(new TicketSoporte("TK-101", "Luis Mora", 2));
        tickets.add(new TicketSoporte("TK-108", "Carlos Vega", 4));
        tickets.add(new TicketSoporte("TK-104", "Ana Torres", 5));
        tickets.add(new TicketSoporte("TK-103", "Luis Andrade", 3));
        tickets.add(new TicketSoporte("TK-107", "Mateo Rojas", 1));
        tickets.add(new TicketSoporte("TK-102", "Sofia Cordero", 4));
        tickets.add(new TicketSoporte("TK-106", "Carlos Mendez", 5));
        tickets.add(new TicketSoporte("TK-105", "Ana Molina", 2));

        System.out.println("-------------- Metodo A - FiltrarYOrdenar --------------");
        
        TicketController controller = new TicketController();

        Set<TicketSoporte> resultado = controller.filtrarYOrdenarTickets(tickets, 3);

        for ( TicketSoporte ticket : resultado){
            System.out.println(ticket.getCodigo() + " - " + ticket.getPrioridad());
        }

        System.out.println("-------------- Metodo B - AgruparCodigosPorPrioridad --------------");

        Map<String, Set<Integer>> resultado2 = controller.agruparCodigosPorPrioridad(tickets);

        for (String codigo : resultado2.keySet()){
            System.out.println(codigo + " - " + resultado2.get(codigo));
        }
        
    }
}

