package k3052.grupo11.seguidorCarrera.ui

import org.uqbar.arena.windows.Dialog
import k3052.grupo11.seguidorCarrera.domain.Nota
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Button

class EditarNotaWindow extends Dialog<Nota> {

	new(WindowOwner owner, Nota model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Editar Nota")
		var fechaYDescripcionPanel = new Panel(mainPanel)
		fechaYDescripcionPanel.setLayout(new ColumnLayout(2))
		new Label(fechaYDescripcionPanel).setText("Fecha: ")
		new TextBox(fechaYDescripcionPanel).bindValueToProperty("fecha")
		new Label(fechaYDescripcionPanel).setText("Descripcion: ")
		new TextBox(fechaYDescripcionPanel).bindValueToProperty("descripcion")
		new CheckBox(fechaYDescripcionPanel).bindValueToProperty("aprobado")
		new Label(fechaYDescripcionPanel).setText("Aprobado")
	}

	override protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick[|this.accept]

	}

}
