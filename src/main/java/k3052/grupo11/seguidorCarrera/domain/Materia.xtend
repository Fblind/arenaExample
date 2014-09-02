package k3052.grupo11.seguidorCarrera.domain

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import java.util.List
import java.util.ArrayList
import java.util.Date
import org.uqbar.commons.model.UserException
import org.uqbar.commons.model.ObservableUtils

@Observable
class Materia extends Entity {

	//TODO: Por que usa las clases ?
	
//	errores: 
//	.-materia no se repita - Done
//	.-el año de la cursada no sea mayor a hoy
//	.-no puede tener el final aprobado si todas sus notas no son true
	
	@Property String nombre
	@Property Integer anioCursada
	@Property Boolean finalAprobado
	@Property String profesorCursada
	@Property String ubicacion
	@Property List<Nota> notas = new ArrayList<Nota>
	
	var anioHoy = (new Date).year + 1900

	new(String nombre, int anioCursada, boolean finalAprobado, String profesorCursada) {
		this._nombre = nombre
		this._anioCursada = anioCursada
		this._finalAprobado = finalAprobado
		this._profesorCursada = profesorCursada
	}

	new() {
	}

	def agregarNota(Nota nota) {
		notas.add(nota)
	}
	
	def eliminarNota(Nota nota) {
		notas.remove(nota)
	}
		
	def validar(){
		if(finalAprobado && !(this.notasAprobadas)){
			throw new UserException("No podes tener el final aprobado si no rendiste nada bien !")
		}
		if(anioCursada > anioHoy){
			throw new UserException("No podes tener una materia de un año mayor a este !")
		}
	}
	
	def notasAprobadas(){
		notas.map[nota | nota.aprobado].forall[aprobado | aprobado == true]
	}

}
