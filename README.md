### Universidad Politecnica Salesiana 
--- 

## Evaluacion estructura de datos - Map y Set 
## Nombres: 
Sebastian Muñoz

## Profesor:
Pablo Torres 

## Fecha: 
06 / 07 / 2026

---

## Explicacion Metodo A

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

---

## Explicacion Metodo B

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

--- 



En el primer metodo utilice la implementacion de un TreeSet<>() porque este me ayuda a que no existan repetidos y podia ordenar comparando segun el codigo de un Ticket1 y un Ticket2 y asi ordene segun la prioridad minima que yo le de. Para el segundo metodo implemente un TreeMap<>() porque este garantiza un agrupamiento en base a un orden del tipo de dato que yo le de, en este caso tipo String y el ordenamiento iba ser de orden alfabetico.

La unicidad de los codigos se garantiza por 
