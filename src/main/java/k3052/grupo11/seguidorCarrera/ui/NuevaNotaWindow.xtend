package k3052.grupo11.seguidorCarrera.ui

import org.uqbar.arena.windows.Dialog
import k3052.grupo11.seguidorCarrera.domain.Nota
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import k3052.grupo11.seguidorCarrera.domain.Materia
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.utils.ApplicationContext
import k3052.grupo11.seguidorCarrera.home.HomeMaterias

class NuevaNotaWindow extends Dialog<Nota> {
	Materia materiaSeleccionada

	new(WindowOwner owner, Nota model, Materia materiaSeleccionada) {
		super(owner, model)
		this.materiaSeleccionada = materiaSeleccionada
	}

	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Agregar Nota")
		mainPanel.setLayout(new VerticalLayout)
		new Label(mainPanel).setText("Fecha: ")
		new TextBox(mainPanel).bindValueToProperty("fecha")
		new Label(mainPanel).setText("Descripcion: ")
		new TextBox(mainPanel).bindValueToProperty("descripcion")
		new Label(mainPanel).setText("Aprobado: ")
		new CheckBox(mainPanel).bindValueToProperty("aprobado")
	}

	override protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick[|this.accept]
	}

	override def executeTask() {

		//homeMaterias.allInstances.findFirst[materia | materia.equals(materiaSeleccionada)].agregarNota(modelObject)
		homeMaterias.create(materiaSeleccionada, modelObject)
		super.executeTask()
	}
	
	//TODO: homeMaterias...
	def homeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia)) as HomeMaterias
	}

}
