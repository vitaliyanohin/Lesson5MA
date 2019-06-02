import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Logging {

  private static final Logger loggerClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
  private static final Logger loggerClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
  private static final Logger loggerAll = Logger.getLogger("org.stepic");

  public static void configureLogging() {
    loggerClassA.setLevel(Level.ALL);
    loggerClassB.setLevel(Level.WARNING);
    loggerAll.setUseParentHandlers(false);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    loggerAll.addHandler(handler);
    handler.setFormatter(new XMLFormatter());
    loggerClassA.info("test");
    loggerClassB.warning("test");
  }
}
