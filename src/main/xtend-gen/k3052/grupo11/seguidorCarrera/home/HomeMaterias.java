package k3052.grupo11.seguidorCarrera.home;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.model.UserException;

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
    Nota _nota_2 = new Nota(_date_2, "2do Parcial", Boolean.valueOf(true));
    List<Nota> _asList = Arrays.<Nota>asList(_nota, _nota_1, _nota_2);
    ArrayList<Nota> _arrayList = new ArrayList<Nota>(_asList);
    this.create("Ingenieria y Sociedad", Integer.valueOf(2005), Boolean.valueOf(true), "Verderrey", "1er Cuatrimestre 1 - Nivel", _arrayList);
    Date _date_3 = new Date();
    Nota _nota_3 = new Nota(_date_3, "Tp", Boolean.valueOf(true));
    Date _date_4 = new Date();
    Nota _nota_4 = new Nota(_date_4, "1erParcial", Boolean.valueOf(true));
    Date _date_5 = new Date();
    Nota _nota_5 = new Nota(_date_5, "2do Parcial", Boolean.valueOf(false));
    List<Nota> _asList_1 = Arrays.<Nota>asList(_nota_3, _nota_4, _nota_5);
    ArrayList<Nota> _arrayList_1 = new ArrayList<Nota>(_asList_1);
    this.create("Quimica", Integer.valueOf(2009), Boolean.valueOf(false), "Castellano", "2do Cuatrimestre 1 - Nivel", _arrayList_1);
    Date _date_6 = new Date();
    Nota _nota_6 = new Nota(_date_6, "Tp", Boolean.valueOf(true));
    Date _date_7 = new Date();
    Nota _nota_7 = new Nota(_date_7, "1erParcial", Boolean.valueOf(true));
    Date _date_8 = new Date();
    Nota _nota_8 = new Nota(_date_8, "2do Parcial", Boolean.valueOf(true));
    List<Nota> _asList_2 = Arrays.<Nota>asList(_nota_6, _nota_7, _nota_8);
    ArrayList<Nota> _arrayList_2 = new ArrayList<Nota>(_asList_2);
    this.create("Sistemas y Organizacinoes", Integer.valueOf(2009), Boolean.valueOf(true), "Un profesor", "Anual 1 - Nivel", _arrayList_2);
    Date _date_9 = new Date();
    Nota _nota_9 = new Nota(_date_9, "Tp", Boolean.valueOf(true));
    Date _date_10 = new Date();
    Nota _nota_10 = new Nota(_date_10, "1erParcial", Boolean.valueOf(true));
    Date _date_11 = new Date();
    Nota _nota_11 = new Nota(_date_11, "2do Parcial", Boolean.valueOf(true));
    List<Nota> _asList_3 = Arrays.<Nota>asList(_nota_9, _nota_10, _nota_11);
    ArrayList<Nota> _arrayList_3 = new ArrayList<Nota>(_asList_3);
    this.create("Paradigmas de Programacion", Integer.valueOf(2010), Boolean.valueOf(true), "Pennella", "2do Cuatrimestre 2 - Nivel", _arrayList_3);
    Date _date_12 = new Date();
    Nota _nota_12 = new Nota(_date_12, "Tp", Boolean.valueOf(false));
    Date _date_13 = new Date();
    Nota _nota_13 = new Nota(_date_13, "1erParcial", Boolean.valueOf(true));
    List<Nota> _asList_4 = Arrays.<Nota>asList(_nota_12, _nota_13);
    ArrayList<Nota> _arrayList_4 = new ArrayList<Nota>(_asList_4);
    this.create("Diseño de Sistemas", Integer.valueOf(2014), Boolean.valueOf(false), "Dodino", "Anual 3 - Nivel", _arrayList_4);
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
  
  public boolean create(final Materia materiaSeleccionada, final Nota nota) {
    List<Materia> _materias = this.getMaterias();
    final Function1<Materia,Boolean> _function = new Function1<Materia,Boolean>() {
      public Boolean apply(final Materia materia) {
        return Boolean.valueOf(materia.equals(materiaSeleccionada));
      }
    };
    Materia _findFirst = IterableExtensions.<Materia>findFirst(_materias, _function);
    return _findFirst.agregarNota(nota);
  }
  
  public void validateCreate(final Materia materia) {
    this.validarMateriaDuplicado(materia);
  }
  
  public void validarMateriaDuplicado(final Materia materia) {
    final String nombre = materia.getNombre();
    List<Materia> _search = this.search(nombre);
    boolean _isEmpty = _search.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      throw new UserException((("Ya cursaste: " + nombre) + "!"));
    }
  }
  
  public List<Materia> search(final String nombre) {
    List<Materia> _allInstances = this.allInstances();
    final Function1<Materia,Boolean> _function = new Function1<Materia,Boolean>() {
      public Boolean apply(final Materia materia) {
        String _nombre = materia.getNombre();
        return Boolean.valueOf(HomeMaterias.this.match(nombre, _nombre));
      }
    };
    Iterable<Materia> _filter = IterableExtensions.<Materia>filter(_allInstances, _function);
    return IterableExtensions.<Materia>toList(_filter);
  }
  
  public boolean match(final Object expectedValue, final Object realValue) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(expectedValue, null);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = Objects.equal(realValue, null);
      if (_equals_1) {
        return false;
      }
      String _string = realValue.toString();
      String _lowerCase = _string.toLowerCase();
      String _string_1 = expectedValue.toString();
      String _lowerCase_1 = _string_1.toLowerCase();
      _xblockexpression = _lowerCase.contains(_lowerCase_1);
    }
    return _xblockexpression;
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
