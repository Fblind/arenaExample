package k3052.grupo11.seguidorCarrera.runnable

import org.uqbar.arena.Application
import k3052.grupo11.seguidorCarrera.ui.SeguidorCarreraWindow
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import k3052.grupo11.seguidorCarrera.home.HomeMaterias
import k3052.grupo11.seguidorCarrera.domain.Materia

class SeguidorCarreraApp extends Application {
	static def void main(String[] args) {
		new SeguidorCarreraApp().start()
	}

	override protected Window<?> createMainWindow() {
		//ApplicationContext.instance.configureSingleton(typeof(Modelo), new HomeModelos)
		ApplicationContext.instance.configureSingleton(typeof(Materia), new HomeMaterias)
		return new SeguidorCarreraWindow(this)
	}

}
