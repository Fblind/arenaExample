package k3052.grupo11.seguidorCarrera.home

import org.uqbar.commons.model.CollectionBasedHome
import k3052.grupo11.seguidorCarrera.domain.Materia
import java.util.List
import k3052.grupo11.seguidorCarrera.domain.Nota
import java.util.Date
import java.util.ArrayList
import java.util.Arrays
import org.uqbar.commons.model.UserException

class HomeMaterias extends CollectionBasedHome<Materia> {

	new() {
		this.init
	}

	def void init() {
		this.create("Ingenieria y Sociedad", 2005, true, "Verderrey", "1er Cuatrimestre 1 - Nivel",
			new ArrayList(
				Arrays.asList(new Nota(new Date, "Tp", true), new Nota(new Date, "1erParcial", true),
					new Nota(new Date, "2do Parcial", true))))
		this.create("Quimica", 2009, false, "Castellano", "2do Cuatrimestre 1 - Nivel",
			new ArrayList(
				Arrays.asList(new Nota(new Date, "Tp", true), new Nota(new Date, "1erParcial", true),
					new Nota(new Date, "2do Parcial", false))))
		this.create("Sistemas y Organizacinoes", 2009, true, "Un profesor", "Anual 1 - Nivel",
			new ArrayList(
				Arrays.asList(new Nota(new Date, "Tp", true), new Nota(new Date, "1erParcial", true),
					new Nota(new Date, "2do Parcial", true))))
		this.create("Paradigmas de Programacion", 2010, true, "Pennella", "2do Cuatrimestre 2 - Nivel",
			new ArrayList(
				Arrays.asList(new Nota(new Date, "Tp", true), new Nota(new Date, "1erParcial", true),
					new Nota(new Date, "2do Parcial", true))))
		this.create("Diseño de Sistemas", 2014, false, "Dodino", "Anual 3 - Nivel",
			new ArrayList(Arrays.asList(new Nota(new Date, "Tp", false), new Nota(new Date, "1erParcial", true))))
	}

	def void create(String pNombre, Integer pAnioCursada, Boolean pFinalAprobado, String pProfesorCursada,
		String pUbicacion, List<Nota> notas) {
		var materia = new Materia
		materia.nombre = pNombre
		materia.anioCursada = pAnioCursada
		materia.finalAprobado = pFinalAprobado
		materia.profesorCursada = pProfesorCursada
		materia.ubicacion = pUbicacion
		materia.notas = notas
		this.create(materia)
	}

	def getMaterias() {
		allInstances.toList
	}

	def create(Materia materiaSeleccionada, Nota nota) {
		materias.findFirst[materia|materia.equals(materiaSeleccionada)].agregarNota(nota)
	}

	override void validateCreate(Materia materia) {
		//materia.validar()
		validarMateriaDuplicado(materia)
	}

	def void validarMateriaDuplicado(Materia materia) {
		val nombre = materia.nombre
		if (!this.search(nombre).isEmpty) {
			throw new UserException("Ya cursaste: " + nombre + "!")
		}
	}

	def search(String nombre) {
		allInstances.filter[materia|this.match(nombre, materia.nombre)].toList
	}

	def match(Object expectedValue, Object realValue) {
		if (expectedValue == null) {
			return true
		}
		if (realValue == null) {
			return false
		}
		realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())
	}

	override protected getCriterio(Materia example) {
		null
	}

	override createExample() {
		new Materia
	}

	override getEntityType() {
		typeof(Materia)
	}

}
