package k3052.grupo11.seguidorCarrera.domain;

import java.util.ArrayList;
import java.util.List;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia extends Entity {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private Integer _anioCursada;
  
  public Integer getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final Integer anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private Boolean _finalAprobado;
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private String _profesorCursada;
  
  public String getProfesorCursada() {
    return this._profesorCursada;
  }
  
  public void setProfesorCursada(final String profesorCursada) {
    this._profesorCursada = profesorCursada;
  }
  
  private String _ubicacion;
  
  public String getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final String ubicacion) {
    this._ubicacion = ubicacion;
  }
  
  private List<Nota> _notas = new ArrayList<Nota>();
  
  public List<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final List<Nota> notas) {
    this._notas = notas;
  }
  
  public Materia(final String nombre, final int anioCursada, final boolean finalAprobado, final String profesorCursada) {
    this._nombre = nombre;
    this._anioCursada = Integer.valueOf(anioCursada);
    this._finalAprobado = Boolean.valueOf(finalAprobado);
    this._profesorCursada = profesorCursada;
  }
  
  public Materia() {
  }
}
