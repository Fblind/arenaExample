package k3052.grupo11.seguidorCarrera.ui;

import k3052.grupo11.seguidorCarrera.applicationModel.BuscadorMaterias;
import k3052.grupo11.seguidorCarrera.domain.Materia;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
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
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    Panel materiasDescripcionPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    materiasDescripcionPanel.setLayout(_verticalLayout_1);
    Label _label_1 = new Label(materiasDescripcionPanel);
    _label_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    Panel anioYFinal = new Panel(materiasDescripcionPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    anioYFinal.setLayout(_horizontalLayout_1);
    Label _label_2 = new Label(anioYFinal);
    _label_2.setText("A�o cursada: ");
    TextBox _textBox = new TextBox(anioYFinal);
    _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
    CheckBox _checkBox = new CheckBox(anioYFinal);
    _checkBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
    Label _label_3 = new Label(anioYFinal);
    _label_3.setText("Final Aprobado");
    Panel profesorYUbicacionPanel = new Panel(materiasDescripcionPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    profesorYUbicacionPanel.setLayout(_columnLayout);
    Label _label_4 = new Label(profesorYUbicacionPanel);
    _label_4.setText("Profesor de cursada ");
    TextBox _textBox_1 = new TextBox(profesorYUbicacionPanel);
    _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesorCursada");
    Label _label_5 = new Label(profesorYUbicacionPanel);
    _label_5.setText("Ubicaci�n Materia ");
    Selector<String> _selector = new Selector<String>(profesorYUbicacionPanel);
    final Procedure1<Selector<String>> _function_2 = new Procedure1<Selector<String>>() {
      public void apply(final Selector<String> it) {
        it.allowNull(false);
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      }
    };
    ObjectExtensions.<Selector<String>>operator_doubleArrow(_selector, _function_2);
    Panel notasDeCursadaPanel = new Panel(materiasDescripcionPanel);
    Label _label_6 = new Label(notasDeCursadaPanel);
    _label_6.setText("Notas de Cursada");
    Table<Materia> table = new Table<Materia>(notasDeCursadaPanel, Materia.class);
    table.setHeigth(200);
    table.setWidth(450);
    table.bindItemsToProperty("notas");
    this.describeResultsGrid(table);
  }
  
  public void describeResultsGrid(final Table<Materia> table) {
    Column<Materia> _column = new Column<Materia>(table);
    Column<Materia> _setTitle = _column.setTitle("Fecha");
    Column<Materia> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("notas.fecha");
  }
}
