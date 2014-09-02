package k3052.grupo11.seguidorCarrera.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
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
  
  private int anioHoy = (new Date().getYear() + 1900);
  
  public Materia(final String nombre, final int anioCursada, final boolean finalAprobado, final String profesorCursada) {
    this._nombre = nombre;
    this._anioCursada = Integer.valueOf(anioCursada);
    this._finalAprobado = Boolean.valueOf(finalAprobado);
    this._profesorCursada = profesorCursada;
  }
  
  public Materia() {
  }
  
  public boolean agregarNota(final Nota nota) {
    List<Nota> _notas = this.getNotas();
    return _notas.add(nota);
  }
  
  public boolean eliminarNota(final Nota nota) {
    List<Nota> _notas = this.getNotas();
    return _notas.remove(nota);
  }
  
  public void validar() {
    boolean _and = false;
    Boolean _finalAprobado = this.getFinalAprobado();
    if (!(_finalAprobado).booleanValue()) {
      _and = false;
    } else {
      boolean _notasAprobadas = this.notasAprobadas();
      boolean _not = (!_notasAprobadas);
      _and = _not;
    }
    if (_and) {
      throw new UserException("No podes tener el final aprobado si no rendiste nada bien !");
    }
    Integer _anioCursada = this.getAnioCursada();
    boolean _greaterThan = ((_anioCursada).intValue() > this.anioHoy);
    if (_greaterThan) {
      throw new UserException("No podes tener una materia de un año mayor a este !");
    }
  }
  
  public boolean notasAprobadas() {
    List<Nota> _notas = this.getNotas();
    final Function1<Nota,Boolean> _function = new Function1<Nota,Boolean>() {
      public Boolean apply(final Nota nota) {
        return nota.getAprobado();
      }
    };
    List<Boolean> _map = ListExtensions.<Nota, Boolean>map(_notas, _function);
    final Function1<Boolean,Boolean> _function_1 = new Function1<Boolean,Boolean>() {
      public Boolean apply(final Boolean aprobado) {
        return Boolean.valueOf(((aprobado).booleanValue() == true));
      }
    };
    return IterableExtensions.<Boolean>forall(_map, _function_1);
  }
}
