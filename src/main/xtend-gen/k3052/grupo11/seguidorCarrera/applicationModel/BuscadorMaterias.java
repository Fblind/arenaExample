package k3052.grupo11.seguidorCarrera.applicationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import k3052.grupo11.seguidorCarrera.home.HomeMaterias;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class BuscadorMaterias implements Serializable {
  private List<Materia> _resultados = new ArrayList<Materia>();
  
  public void setResultados(final List<Materia> resultados) {
    this._resultados = resultados;
  }
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private Nota _notaSeleccionada;
  
  public Nota getNotaSeleccionada() {
    return this._notaSeleccionada;
  }
  
  public void setNotaSeleccionada(final Nota notaSeleccionada) {
    this._notaSeleccionada = notaSeleccionada;
  }
  
  public void search() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setResultados(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    List<Materia> _materias = _homeMaterias.getMaterias();
    this.setResultados(_materias);
  }
  
  public List<Materia> getResultados() {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    return _homeMaterias.getMaterias();
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
  
  public void eliminarNotaSeleccionada() {
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    Nota _notaSeleccionada = this.getNotaSeleccionada();
    _materiaSeleccionada.eliminarNota(_notaSeleccionada);
    this.actualizar();
  }
  
  public void nuevaNota(final Nota notaParaAgregar) {
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    _materiaSeleccionada.agregarNota(notaParaAgregar);
    this.actualizar();
  }
  
  public void actualizar() {
    this.search();
    this.setNotaSeleccionada(null);
  }
}
