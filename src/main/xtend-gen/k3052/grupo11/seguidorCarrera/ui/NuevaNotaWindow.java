package k3052.grupo11.seguidorCarrera.ui;

import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.domain.Nota;
import k3052.grupo11.seguidorCarrera.home.HomeMaterias;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class NuevaNotaWindow extends Dialog<Nota> {
  private Materia materiaSeleccionada;
  
  public NuevaNotaWindow(final WindowOwner owner, final Nota model, final Materia materiaSeleccionada) {
    super(owner, model);
    this.materiaSeleccionada = materiaSeleccionada;
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Agregar Nota");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Fecha: ");
    TextBox _textBox = new TextBox(mainPanel);
    _textBox.<ControlBuilder>bindValueToProperty("fecha");
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Descripcion: ");
    TextBox _textBox_1 = new TextBox(mainPanel);
    _textBox_1.<ControlBuilder>bindValueToProperty("descripcion");
    Label _label_2 = new Label(mainPanel);
    _label_2.setText("Aprobado: ");
    CheckBox _checkBox = new CheckBox(mainPanel);
    _checkBox.<ControlBuilder>bindValueToProperty("aprobado");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        NuevaNotaWindow.this.accept();
      }
    };
    _setCaption.onClick(_function);
  }
  
  public void executeTask() {
    HomeMaterias _homeMaterias = this.homeMaterias();
    Nota _modelObject = this.getModelObject();
    _homeMaterias.create(this.materiaSeleccionada, _modelObject);
    super.executeTask();
  }
  
  public HomeMaterias homeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Materia.class);
    return ((HomeMaterias) _singleton);
  }
}
