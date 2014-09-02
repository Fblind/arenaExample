package k3052.grupo11.seguidorCarrera.home;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    Date _date = new Date();
    Nota _nota = new Nota(_date, "Tp", Boolean.valueOf(true));
    Date _date_1 = new Date();
    Nota _nota_1 = new Nota(_date_1, "1erParcial", Boolean.valueOf(true));
    Date _date_2 = new Date();
    Nota _nota_2 = new Nota(_date_2, "2do Parcial", Boolean.valueOf(false));
    this.create("Ingenieria y sociedad", Integer.valueOf(2005), Boolean.valueOf(true), "asd", "asdasd", Collections.<Nota>unmodifiableList(Lists.<Nota>newArrayList(_nota, _nota_1, _nota_2)));
    Date _date_3 = new Date();
    Nota _nota_3 = new Nota(_date_3, "Tp", Boolean.valueOf(true));
    Date _date_4 = new Date();
    Nota _nota_4 = new Nota(_date_4, "1erParcial", Boolean.valueOf(true));
    Date _date_5 = new Date();
    Nota _nota_5 = new Nota(_date_5, "2do Parcial", Boolean.valueOf(false));
    this.create("asdas", Integer.valueOf(1233), Boolean.valueOf(false), "addd", "asda", Collections.<Nota>unmodifiableList(Lists.<Nota>newArrayList(_nota_3, _nota_4, _nota_5)));
    Date _date_6 = new Date();
    Nota _nota_6 = new Nota(_date_6, "Tp", Boolean.valueOf(true));
    Date _date_7 = new Date();
    Nota _nota_7 = new Nota(_date_7, "1erParcial", Boolean.valueOf(true));
    Date _date_8 = new Date();
    Nota _nota_8 = new Nota(_date_8, "2do Parcial", Boolean.valueOf(false));
    this.create("asdas", Integer.valueOf(1231), Boolean.valueOf(true), "asd", "asdasd", Collections.<Nota>unmodifiableList(Lists.<Nota>newArrayList(_nota_6, _nota_7, _nota_8)));
    Date _date_9 = new Date();
    Nota _nota_9 = new Nota(_date_9, "Tp", Boolean.valueOf(true));
    Date _date_10 = new Date();
    Nota _nota_10 = new Nota(_date_10, "1erParcial", Boolean.valueOf(true));
    Date _date_11 = new Date();
    Nota _nota_11 = new Nota(_date_11, "2do Parcial", Boolean.valueOf(false));
    this.create("aaaaa", Integer.valueOf(1231), Boolean.valueOf(false), "asd", "asda", Collections.<Nota>unmodifiableList(Lists.<Nota>newArrayList(_nota_9, _nota_10, _nota_11)));
    Date _date_12 = new Date();
    Nota _nota_12 = new Nota(_date_12, "Tp", Boolean.valueOf(true));
    Date _date_13 = new Date();
    Nota _nota_13 = new Nota(_date_13, "1erParcial", Boolean.valueOf(true));
    Date _date_14 = new Date();
    Nota _nota_14 = new Nota(_date_14, "2do Parcial", Boolean.valueOf(false));
    this.create("afasddd", Integer.valueOf(1233), Boolean.valueOf(true), "adddd", "adas", Collections.<Nota>unmodifiableList(Lists.<Nota>newArrayList(_nota_12, _nota_13, _nota_14)));
  }
  
  public void create(final String pNombre, final Integer pAnioCursada, final Boolean pFinalAprobado, final String pProfesorCursada, final String pUbicacion, final List<Nota> notas) {
    Materia materia = new Materia();
    materia.setNombre(pNombre);
    materia.setAnioCursada(pAnioCursada);
    materia.setFinalAprobado(pFinalAprobado);
    materia.setProfesorCursada(pProfesorCursada);
    materia.setUbicacion(pUbicacion);
    materia.setNotas(notas);
    this.create(materia);
  }
  
  public List<Materia> getMaterias() {
    List<Materia> _allInstances = this.allInstances();
    return IterableExtensions.<Materia>toList(_allInstances);
  }
  
  protected Predicate getCriterio(final Materia example) {
    return null;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
}
