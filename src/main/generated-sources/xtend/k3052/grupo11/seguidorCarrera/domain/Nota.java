package k3052.grupo11.seguidorCarrera.domain;

import java.util.Date;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Nota {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  private Boolean _aprobado;
  
  public Boolean getAprobado() {
    return this._aprobado;
  }
  
  public void setAprobado(final Boolean aprobado) {
    this._aprobado = aprobado;
  }
  
  public Nota(final Date fecha, final String descripcion, final Boolean aprobado) {
    this._fecha = fecha;
    this._descripcion = descripcion;
    this._aprobado = aprobado;
  }
  
  public Nota() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
