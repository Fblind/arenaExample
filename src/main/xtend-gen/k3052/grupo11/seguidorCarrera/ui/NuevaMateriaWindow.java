package k3052.grupo11.seguidorCarrera.ui;

import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.home.HomeMaterias;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class NuevaMateriaWindow extends Dialog<Materia> {
  public NuevaMateriaWindow(final WindowOwner owner, final Materia model) {
    super(owner, model);
  }
  
  protected void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Nueva Materia");
    this.createFormPanel(mainPanel);
    this.addActions(mainPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Nueva Materia: ");
    TextBox _textBox = new TextBox(mainPanel);
    _textBox.<ControlBuilder>bindValueToProperty("nombre");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        NuevaMateriaWindow.this.accept();
      }
    };
    _setCaption.onClick(_function);
  }
  
  public void executeTask() {
    HomeMaterias _homeMaterias = this.homeMaterias();
    Materia _modelObject = this.getModelObject();
    _homeMaterias.create(_modelObject);
    super.executeTask();
  }
  
  public HomeMaterias homeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Materia.class);
    return ((HomeMaterias) _singleton);
  }
}
