package models;

public class TicketSoporte {
  private String codigo;
  private String tecnico; 
  private int prioridad;
  
  public TicketSoporte(String codigo, String tecnico, int prioridad) {
    this.codigo = codigo;
    this.tecnico = tecnico;
    this.prioridad = prioridad;
  }

  public TicketSoporte() {
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getTecnico() {
    return tecnico;
  }

  public void setTecnico(String tecnico) {
    this.tecnico = tecnico;
  }

  public int getPrioridad() {
    return prioridad;
  }

  public void setPrioridad(int prioridad) {
    this.prioridad = prioridad;
  }

  @Override
  public String toString() {
    return "TicketSoporte [codigo=" + codigo + ", tecnico=" + tecnico + ", prioridad=" + prioridad + "]";
  }

  
}
