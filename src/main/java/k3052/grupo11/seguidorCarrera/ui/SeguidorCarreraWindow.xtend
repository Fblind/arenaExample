package k3052.grupo11.seguidorCarrera.ui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import k3052.grupo11.seguidorCarrera.domain.Materia
import org.uqbar.arena.windows.WindowOwner
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.List
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Button
import k3052.grupo11.seguidorCarrera.applicationModel.BuscadorMaterias
import k3052.grupo11.seguidorCarrera.runnable.SeguidorCarreraApp
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.tables.Table
import k3052.grupo11.seguidorCarrera.domain.Nota
import org.uqbar.arena.widgets.tables.Column
import javax.swing.plaf.basic.BasicBorders.ButtonBorder
import org.uqbar.arena.windows.Dialog
import org.uqbar.commons.model.ObservableObject
import org.uqbar.arena.bindings.ObservableProperty
import java.util.ArrayList
import java.util.Arrays
import org.uqbar.arena.bindings.NotNullObservable
import com.uqbar.commons.StringUtils

class SeguidorCarreraWindow extends SimpleWindow<BuscadorMaterias> {

	new(WindowOwner parent, BuscadorMaterias model) {
		super(parent, model)
	}

	new(WindowOwner parent) {
		super(parent, new BuscadorMaterias)
	}

	override protected addActions(Panel actionsPanel) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	//TODO: Validaciones
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Seguidor de carrera")
		mainPanel.setLayout(new HorizontalLayout)

		var materiasPanel = new Panel(mainPanel)
		materiasPanel.setLayout(new VerticalLayout)
		new Label(materiasPanel).setText("Materias")
		new List(materiasPanel) => [
			allowNull(false)
			bindItemsToProperty("resultados").setAdapter(new PropertyAdapter(typeof(Materia), "nombre"))
			bindValueToProperty("materiaSeleccionada")
		]
		new Button(materiasPanel) => [
			caption = "Nueva Materia"
			onClick [|this.nuevaMateria]
		]

		var materiasDescripcionPanel = new Panel(mainPanel)
		materiasDescripcionPanel.setLayout(new VerticalLayout)
		new Label(materiasDescripcionPanel).bindValueToProperty("materiaSeleccionada.nombre")

		var anioYFinal = new Panel(materiasDescripcionPanel)
		anioYFinal.setLayout(new ColumnLayout(2))
		var anio = new Panel(anioYFinal)
		anio.setLayout(new HorizontalLayout)
		new Label(anio).setText("Año cursada: ")
		var textAnio = new TextBox(anio).bindValueToProperty("materiaSeleccionada.anioCursada")
		var final = new Panel(anioYFinal)
		final.setLayout(new HorizontalLayout)
		var checkFinal = new CheckBox(final).bindValueToProperty("materiaSeleccionada.finalAprobado")
		new Label(final).setText("Final Aprobado")

		var profesorYUbicacionPanel = new Panel(materiasDescripcionPanel)
		profesorYUbicacionPanel.setLayout(new ColumnLayout(2))
		new Label(profesorYUbicacionPanel).setText("Profesor de cursada ")
		var textProfesor = new TextBox(profesorYUbicacionPanel).bindValueToProperty("materiaSeleccionada.profesorCursada")
		new Label(profesorYUbicacionPanel).setText("Ubicación Materia ")
		var selectorUbicacion = new Selector<String>(profesorYUbicacionPanel) => [
			allowNull(false)
			bindItems(new ObservableProperty(this, "ubicaciones"))
			bindValueToProperty("materiaSeleccionada.ubicacion")
		]

		var notasDeCursadaPanel = new Panel(materiasDescripcionPanel)
		new Label(notasDeCursadaPanel).setText("Notas de Cursada")
		var tableNotas = new Table<Nota>(notasDeCursadaPanel, typeof(Nota)) => [ table |
			table.heigth = 200
			table.width = 450
			table.bindItemsToProperty("materiaSeleccionada.notas")
			table.bindValueToProperty("notaSeleccionada")
			//table.bindValue(new ObservableProperty(BuscadorNotas, "notaSeleccionada"))
			this.describeResultsGrid(table)
		]

		var botoneraCursadaPanel = new Panel(materiasDescripcionPanel)
		botoneraCursadaPanel.setLayout(new HorizontalLayout)
		var buttonEditarNota = new Button(botoneraCursadaPanel) => [
			caption = "Editar"
			onClick [|this.editarNota]
		]
		var buttonNuevaNota = new Button(botoneraCursadaPanel) => [
			caption = "+"
			onClick [|this.nuevaNota(modelObject.materiaSeleccionada)]
		]
		var buttonEliminarNota = new Button(botoneraCursadaPanel) => [
			caption = "-"
			onClick [|modelObject.eliminarNotaSeleccionada]
		]
		
		var materiaSelected = new NotNullObservable("materiaSeleccionada")
		buttonNuevaNota.bindEnabled(materiaSelected)
		//TODO: Como se puede hacer ?
		//textAnio.bindEnabled(materiaSelected)
		//checkFinal
		selectorUbicacion.bindEnabled(materiaSelected)
		
		var notaSelected = new NotNullObservable("notaSeleccionada")
		buttonEditarNota.bindEnabled(notaSelected)
		buttonEliminarNota.bindEnabled(notaSelected)
		

	}

	def void describeResultsGrid(Table<Nota> table) {
		new Column<Nota>(table).setTitle("Fecha").setFixedSize(150).bindContentsToProperty("fecha")

		new Column<Nota>(table).setTitle("Descripcion").setFixedSize(150).bindContentsToProperty("descripcion")

		new Column<Nota>(table).setTitle("Aprobado").setFixedSize(150).
			bindContentsToTransformer([nota|if(nota.aprobado) "SI" else "NO"])
	}

	def void nuevaMateria() {
		this.openDialog(new NuevaMateriaWindow(this, new Materia))
	}

	def void editarNota() {
		this.openDialog(new EditarNotaWindow(this, modelObject.notaSeleccionada))
	}

	def nuevaNota(Materia materia) {
		this.openDialog(new NuevaNotaWindow(this, new Nota, materia))
	}

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.search]
		dialog.open
	}

	def getUbicaciones() {

		//Enum ?
		new ArrayList(
			Arrays.asList("1er Cuatrimestre 1 - Nivel", "2do Cuatrimestre 1 - Nivel", "Anual 1 - Nivel",
				"1er Cuatrimestre 2 - Nivel", "2do Cuatrimestre 2 - Nivel", "Anual 2 - Nivel",
				"1er Cuatrimestre 3 - Nivel", "2do Cuatrimestre 3 - Nivel", "Anual 3 - Nivel",
				"1er Cuatrimestre 4 - Nivel", "2do Cuatrimestre 4 - Nivel", "Anual 4 - Nivel",
				"1er Cuatrimestre 5 - Nivel", "2do Cuatrimestre 5 - Nivel", "Anual 5 - Nivel"))
	}

}
