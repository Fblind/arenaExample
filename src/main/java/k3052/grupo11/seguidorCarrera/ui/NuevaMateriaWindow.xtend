package k3052.grupo11.seguidorCarrera.ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import k3052.grupo11.seguidorCarrera.domain.Materia
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import k3052.grupo11.seguidorCarrera.home.HomeMaterias
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.arena.bindings.PropertyAdapter

class NuevaMateriaWindow extends Dialog<Materia> {

	new(WindowOwner owner, Materia model) {
		super(owner, model)
	}

	override protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Nueva Materia")
		this.createFormPanel(mainPanel)
		this.addActions(mainPanel)
	}

	override protected createFormPanel(Panel mainPanel) {
		//this.setTitle("Nueva Materia")
		mainPanel.setLayout(new VerticalLayout)
		new Label(mainPanel).setText("Nueva Materia: ")
		new TextBox(mainPanel).bindValueToProperty("nombre")
	}

	override protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick[|this.accept]
	}

	override def executeTask() {
		//ObservableUtils::firePropertyChanged(Materia, "finalAprobado", new PropertyAdapter(typeof(Materia), "notasAprobadas()"))
		homeMaterias.create(modelObject)
		super.executeTask()
	}

	def homeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia)) as HomeMaterias
	}

}
