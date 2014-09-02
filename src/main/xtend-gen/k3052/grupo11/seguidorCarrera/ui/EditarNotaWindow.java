package k3052.grupo11.seguidorCarrera.ui;

import k3052.grupo11.seguidorCarrera.domain.Nota;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class EditarNotaWindow extends Dialog<Nota> {
  public EditarNotaWindow(final WindowOwner owner, final Nota model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Editar Nota");
    Panel fechaYDescripcionPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    fechaYDescripcionPanel.setLayout(_columnLayout);
    Label _label = new Label(fechaYDescripcionPanel);
    _label.setText("Fecha: ");
    TextBox _textBox = new TextBox(fechaYDescripcionPanel);
    _textBox.<ControlBuilder>bindValueToProperty("fecha");
    Label _label_1 = new Label(fechaYDescripcionPanel);
    _label_1.setText("Descripcion: ");
    TextBox _textBox_1 = new TextBox(fechaYDescripcionPanel);
    _textBox_1.<ControlBuilder>bindValueToProperty("descripcion");
    CheckBox _checkBox = new CheckBox(fechaYDescripcionPanel);
    _checkBox.<ControlBuilder>bindValueToProperty("aprobado");
    Label _label_2 = new Label(fechaYDescripcionPanel);
    _label_2.setText("Aprobado");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        EditarNotaWindow.this.accept();
      }
    };
    _setCaption.onClick(_function);
  }
}
