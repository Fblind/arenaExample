package k3052.grupo11.seguidorCarrera.home;

import java.util.Date;
import java.util.List;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomeNotas extends CollectionBasedHome<Nota> {
  public HomeNotas() {
    this.init();
  }
  
  public void init() {
    Date _date = new Date();
    this.create(_date, "TP", Boolean.valueOf(true));
    Date _date_1 = new Date();
    this.create(_date_1, "Parcial 1", Boolean.valueOf(true));
    Date _date_2 = new Date();
    this.create(_date_2, "Parcial 2", Boolean.valueOf(true));
  }
  
  public void create(final Date pFecha, final String pDescripcion, final Boolean pAprobado) {
    Nota nota = new Nota();
    nota.setFecha(pFecha);
    nota.setDescripcion(pDescripcion);
    nota.setAprobado(pAprobado);
    this.create(nota);
  }
  
  public List<Nota> getMaterias() {
    List<Nota> _allInstances = this.allInstances();
    return IterableExtensions.<Nota>toList(_allInstances);
  }
  
  protected Predicate getCriterio(final Nota example) {
    return null;
  }
  
  public Nota createExample() {
    return new Nota();
  }
  
  public Class<Nota> getEntityType() {
    return Nota.class;
  }
}
