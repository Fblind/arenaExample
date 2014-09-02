package k3052.grupo11.seguidorCarrera.domain

import java.util.Date
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class Nota extends Entity{
	
	@Property Date fecha
	@Property String descripcion
	@Property Boolean aprobado
	
	new(Date fecha, String descripcion, Boolean aprobado) {
		this._fecha = fecha
		this._descripcion = descripcion
		this._aprobado = aprobado
	}
	
	new() {

	}
	
	
}