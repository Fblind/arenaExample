package k3052.grupo11.seguidorCarrera.runnable;

import k3052.grupo11.seguidorCarrera.domain.Materia;
import k3052.grupo11.seguidorCarrera.home.HomeMaterias;
import k3052.grupo11.seguidorCarrera.ui.SeguidorCarreraWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class SeguidorCarreraApp extends Application {
  public static void main(final String[] args) {
    SeguidorCarreraApp _seguidorCarreraApp = new SeguidorCarreraApp();
    _seguidorCarreraApp.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
    return new SeguidorCarreraWindow(this);
  }
}
