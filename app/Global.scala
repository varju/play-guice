import com.google.inject.{Guice, AbstractModule}
import play.api.GlobalSettings
import services.{WelcomeTextGenerator, TextGenerator}

/**
 * Set up general configuration for the application. In particular we set up the Guice context.
 */
object Global extends GlobalSettings {

  /**
   * Bind types such that whenever TextGenerator is requried, an instance of TextGenerator will be used.
   */
  val injector = Guice.createInjector(new AbstractModule {
    protected def configure() {
      bind(classOf[TextGenerator]).to(classOf[WelcomeTextGenerator])
    }
  })

  /**
   * Controllers must be resolved through the application context. There is a special method of GlobalSettings
   * that we can override to resolve a given controller. This resolution is required by the Play router.
   */
  override def getControllerInstance[A](controllerClass: Class[A]): A = injector.getInstance(controllerClass)
}
