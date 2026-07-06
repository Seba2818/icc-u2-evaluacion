package controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.TicketSoporte;

public class TicketController {

  public Set<TicketSoporte> filtrarYOrdenarTickets(List<TicketSoporte> tickets, int prioridadMinima) {

    Set<TicketSoporte> resultado = new TreeSet<>((ticket1, ticket2) -> {

      if (ticket1.getCodigo().equalsIgnoreCase(ticket2.getCodigo())
          && ticket1.getPrioridad() == ticket2.getPrioridad()) {
        return 0;
      }

      if (ticket1.getPrioridad() != ticket2.getPrioridad()) {
        return Integer.compare(ticket2.getPrioridad(), ticket1.getPrioridad());
      }

      int comparadorx = ticket1.getTecnico().compareToIgnoreCase(ticket2.getTecnico());
      if (comparadorx != 0) {
        return comparadorx;
      }

      return ticket1.getCodigo().compareToIgnoreCase(ticket2.getCodigo());
    });

    for (TicketSoporte ticket : tickets) {
      if (ticket.getPrioridad() >= prioridadMinima) {
        resultado.add(ticket);
      }
    }

    return resultado;
  }

  public Map<String, Set<Integer>> agruparCodigosPorPrioridad(List<TicketSoporte> tickets) {

    Map<String, Set<Integer>> resultado = new TreeMap<>();

    resultado.put("ALTA", new TreeSet<>());
    resultado.put("BAJA", new TreeSet<>());
    resultado.put("MEDIA", new TreeSet<>());

    for (TicketSoporte ticket : tickets) {

      int numero = Integer.parseInt(ticket.getCodigo().split("-")[1]);

      if (ticket.getPrioridad() >= 4) {
        resultado.get("ALTA").add(numero);
      } else if (ticket.getPrioridad() >= 2) {
        resultado.get("MEDIA").add(numero);
      } else {
        resultado.get("BAJA").add(numero);
      }
    }

    return resultado;
  }
}
