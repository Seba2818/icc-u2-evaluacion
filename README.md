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



En el **método A** se utiliza un **`TreeSet<TicketSoporte>`**, ya que esta implementación de la interfaz **`Set`** garantiza la **unicidad** de los elementos, evitando que se almacenen tickets duplicados según el criterio definido en el comparador. Un ticket se considera repetido cuando posee el mismo código y la misma prioridad, por lo que el comparador retorna `0` y el `TreeSet` no lo inserta nuevamente. Además de eliminar duplicados, esta estructura mantiene los elementos **ordenados automáticamente**, primero por prioridad de forma descendente, luego por el nombre del técnico en orden alfabético y, finalmente, por el código del ticket. La lógica del método consiste en filtrar únicamente los tickets cuya prioridad sea igual o superior al valor mínimo recibido como parámetro y agregarlos al `TreeSet`, obteniendo como resultado un conjunto de tickets únicos y ordenados.

En el **método B** se emplea un **`TreeMap<String, Set<Integer>>`**, implementación de la interfaz **`Map`**, cuya función es asociar una clave con un conjunto de valores. Las claves corresponden a las categorías de prioridad (**ALTA**, **MEDIA** y **BAJA**) y se almacenan ordenadas alfabéticamente gracias a `TreeMap`. Como valor de cada clave se utiliza un **`TreeSet<Integer>`**, el cual asegura la **unicidad** de los números de código dentro de cada categoría y los mantiene ordenados de menor a mayor. La lógica implementada consiste en recorrer la lista de tickets, extraer la parte numérica del código, clasificar cada ticket según su nivel de prioridad y agregar el número al conjunto correspondiente. De esta forma, el resultado es una estructura organizada por categorías de prioridad, sin números repetidos y con todos los elementos ordenados automáticamente.
