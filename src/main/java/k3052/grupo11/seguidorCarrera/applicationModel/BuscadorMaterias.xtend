package k3052.grupo11.seguidorCarrera.applicationModel

import java.util.List
import k3052.grupo11.seguidorCarrera.domain.Materia
import java.util.ArrayList
import k3052.grupo11.seguidorCarrera.home.HomeMaterias
import org.uqbar.commons.utils.ApplicationContext
import java.io.Serializable
import org.uqbar.commons.utils.Observable
import k3052.grupo11.seguidorCarrera.domain.Nota

@Observable
class BuscadorMaterias implements Serializable {

	@Property List<Materia> resultados = new ArrayList<Materia>
	@Property Materia materiaSeleccionada
	@Property Nota notaSeleccionada

	def void search() {
		resultados = new ArrayList<Materia>
		resultados = getHomeMaterias().materias
	}

	def getResultados() {
		getHomeMaterias.materias
	}

	def HomeMaterias getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia))
	}

	def void eliminarNotaSeleccionada() {
		materiaSeleccionada.eliminarNota(notaSeleccionada)
		this.actualizar
	}

	def void nuevaNota(Nota notaParaAgregar) {
		materiaSeleccionada.agregarNota(notaParaAgregar)
		this.actualizar
	}

	def actualizar() {
		this.search()
		notaSeleccionada = null
	}

}
