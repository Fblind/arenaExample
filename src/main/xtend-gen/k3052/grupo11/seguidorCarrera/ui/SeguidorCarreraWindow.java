package k3052.grupo11.seguidorCarrera.ui;

import com.uqbar.commons.collections.Transformer;
import java.util.ArrayList;
import java.util.Arrays;
import k3052.grupo11.seguidorCarrera.applicationModel.BuscadorMaterias;
import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import k3052.grupo11.seguidorCarrera.ui.EditarNotaWindow;
import k3052.grupo11.seguidorCarrera.ui.NuevaMateriaWindow;
import k3052.grupo11.seguidorCarrera.ui.NuevaNotaWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class SeguidorCarreraWindow extends SimpleWindow<BuscadorMaterias> {
  public SeguidorCarreraWindow(final WindowOwner parent, final BuscadorMaterias model) {
    super(parent, model);
  }
  
  public SeguidorCarreraWindow(final WindowOwner parent) {
    super(parent, new BuscadorMaterias());
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Seguidor de carrera");
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    mainPanel.setLayout(_horizontalLayout);
    Panel materiasPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    materiasPanel.setLayout(_verticalLayout);
    Label _label = new Label(materiasPanel);
    _label.setText("Materias");
    List<Object> _list = new List<Object>(materiasPanel);
    final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        it.allowNull(false);
        Binding<ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("resultados");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Materia.class, "nombre");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    Button _button = new Button(materiasPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Nueva Materia");
        final Action _function = new Action() {
          public void execute() {
            SeguidorCarreraWindow.this.nuevaMateria();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    Panel materiasDescripcionPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    materiasDescripcionPanel.setLayout(_verticalLayout_1);
    Label _label_1 = new Label(materiasDescripcionPanel);
    _label_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    Panel anioYFinal = new Panel(materiasDescripcionPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    anioYFinal.setLayout(_columnLayout);
    Panel anio = new Panel(anioYFinal);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    anio.setLayout(_horizontalLayout_1);
    Label _label_2 = new Label(anio);
    _label_2.setText("Año cursada: ");
    TextBox _textBox = new TextBox(anio);
    Binding<ControlBuilder> textAnio = _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
    Panel final_ = new Panel(anioYFinal);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    final_.setLayout(_horizontalLayout_2);
    CheckBox _checkBox = new CheckBox(final_);
    Binding<ControlBuilder> checkFinal = _checkBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
    Label _label_3 = new Label(final_);
    _label_3.setText("Final Aprobado");
    Panel profesorYUbicacionPanel = new Panel(materiasDescripcionPanel);
    ColumnLayout _columnLayout_1 = new ColumnLayout(2);
    profesorYUbicacionPanel.setLayout(_columnLayout_1);
    Label _label_4 = new Label(profesorYUbicacionPanel);
    _label_4.setText("Profesor de cursada ");
    TextBox _textBox_1 = new TextBox(profesorYUbicacionPanel);
    Binding<ControlBuilder> textProfesor = _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesorCursada");
    Label _label_5 = new Label(profesorYUbicacionPanel);
    _label_5.setText("Ubicación Materia ");
    Selector<String> _selector = new Selector<String>(profesorYUbicacionPanel);
    final Procedure1<Selector<String>> _function_2 = new Procedure1<Selector<String>>() {
      public void apply(final Selector<String> it) {
        it.allowNull(false);
        ObservableProperty _observableProperty = new ObservableProperty(SeguidorCarreraWindow.this, "ubicaciones");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      }
    };
    Selector<String> selectorUbicacion = ObjectExtensions.<Selector<String>>operator_doubleArrow(_selector, _function_2);
    Panel notasDeCursadaPanel = new Panel(materiasDescripcionPanel);
    Label _label_6 = new Label(notasDeCursadaPanel);
    _label_6.setText("Notas de Cursada");
    Table<Nota> _table = new Table<Nota>(notasDeCursadaPanel, Nota.class);
    final Procedure1<Table<Nota>> _function_3 = new Procedure1<Table<Nota>>() {
      public void apply(final Table<Nota> table) {
        table.setHeigth(200);
        table.setWidth(450);
        table.bindItemsToProperty("materiaSeleccionada.notas");
        table.<ControlBuilder>bindValueToProperty("notaSeleccionada");
        SeguidorCarreraWindow.this.describeResultsGrid(table);
      }
    };
    Table<Nota> tableNotas = ObjectExtensions.<Table<Nota>>operator_doubleArrow(_table, _function_3);
    Panel botoneraCursadaPanel = new Panel(materiasDescripcionPanel);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    botoneraCursadaPanel.setLayout(_horizontalLayout_3);
    Button _button_1 = new Button(botoneraCursadaPanel);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar");
        final Action _function = new Action() {
          public void execute() {
            SeguidorCarreraWindow.this.editarNota();
          }
        };
        it.onClick(_function);
      }
    };
    Button buttonEditarNota = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_4);
    Button _button_2 = new Button(botoneraCursadaPanel);
    final Procedure1<Button> _function_5 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("+");
        final Action _function = new Action() {
          public void execute() {
            BuscadorMaterias _modelObject = SeguidorCarreraWindow.this.getModelObject();
            Materia _materiaSeleccionada = _modelObject.getMateriaSeleccionada();
            SeguidorCarreraWindow.this.nuevaNota(_materiaSeleccionada);
          }
        };
        it.onClick(_function);
      }
    };
    Button buttonNuevaNota = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_5);
    Button _button_3 = new Button(botoneraCursadaPanel);
    final Procedure1<Button> _function_6 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("-");
        final Action _function = new Action() {
          public void execute() {
            BuscadorMaterias _modelObject = SeguidorCarreraWindow.this.getModelObject();
            _modelObject.eliminarNotaSeleccionada();
          }
        };
        it.onClick(_function);
      }
    };
    Button buttonEliminarNota = ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_6);
    NotNullObservable materiaSelected = new NotNullObservable("materiaSeleccionada");
    buttonNuevaNota.<ControlBuilder>bindEnabled(materiaSelected);
    selectorUbicacion.<ControlBuilder>bindEnabled(materiaSelected);
    NotNullObservable notaSelected = new NotNullObservable("notaSeleccionada");
    buttonEditarNota.<ControlBuilder>bindEnabled(notaSelected);
    buttonEliminarNota.<ControlBuilder>bindEnabled(notaSelected);
  }
  
  public void describeResultsGrid(final Table<Nota> table) {
    Column<Nota> _column = new Column<Nota>(table);
    Column<Nota> _setTitle = _column.setTitle("Fecha");
    Column<Nota> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("fecha");
    Column<Nota> _column_1 = new Column<Nota>(table);
    Column<Nota> _setTitle_1 = _column_1.setTitle("Descripcion");
    Column<Nota> _setFixedSize_1 = _setTitle_1.setFixedSize(150);
    _setFixedSize_1.bindContentsToProperty("descripcion");
    Column<Nota> _column_2 = new Column<Nota>(table);
    Column<Nota> _setTitle_2 = _column_2.setTitle("Aprobado");
    Column<Nota> _setFixedSize_2 = _setTitle_2.setFixedSize(150);
    final Transformer<Nota,String> _function = new Transformer<Nota,String>() {
      public String transform(final Nota nota) {
        String _xifexpression = null;
        Boolean _aprobado = nota.getAprobado();
        if ((_aprobado).booleanValue()) {
          _xifexpression = "SI";
        } else {
          _xifexpression = "NO";
        }
        return _xifexpression;
      }
    };
    _setFixedSize_2.<String>bindContentsToTransformer(_function);
  }
  
  public void nuevaMateria() {
    Materia _materia = new Materia();
    NuevaMateriaWindow _nuevaMateriaWindow = new NuevaMateriaWindow(this, _materia);
    this.openDialog(_nuevaMateriaWindow);
  }
  
  public void editarNota() {
    BuscadorMaterias _modelObject = this.getModelObject();
    Nota _notaSeleccionada = _modelObject.getNotaSeleccionada();
    EditarNotaWindow _editarNotaWindow = new EditarNotaWindow(this, _notaSeleccionada);
    this.openDialog(_editarNotaWindow);
  }
  
  public void nuevaNota(final Materia materia) {
    Nota _nota = new Nota();
    NuevaNotaWindow _nuevaNotaWindow = new NuevaNotaWindow(this, _nota, materia);
    this.openDialog(_nuevaNotaWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        BuscadorMaterias _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.search();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public ArrayList<String> getUbicaciones() {
    java.util.List<String> _asList = Arrays.<String>asList("1er Cuatrimestre 1 - Nivel", "2do Cuatrimestre 1 - Nivel", "Anual 1 - Nivel", 
      "1er Cuatrimestre 2 - Nivel", "2do Cuatrimestre 2 - Nivel", "Anual 2 - Nivel", 
      "1er Cuatrimestre 3 - Nivel", "2do Cuatrimestre 3 - Nivel", "Anual 3 - Nivel", 
      "1er Cuatrimestre 4 - Nivel", "2do Cuatrimestre 4 - Nivel", "Anual 4 - Nivel", 
      "1er Cuatrimestre 5 - Nivel", "2do Cuatrimestre 5 - Nivel", "Anual 5 - Nivel");
    return new ArrayList<String>(_asList);
  }
}
