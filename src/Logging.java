import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Logging {

  private static final Logger LOGGER_CLASS_A = Logger.getLogger("org.stepic.java.logging.ClassA");
  private static final Logger LOGGER_CLASS_B = Logger.getLogger("org.stepic.java.logging.ClassB");
  private static final Logger LOGGER_ALL = Logger.getLogger("org.stepic");

  public static void configureLogging() {
    LOGGER_CLASS_A.setLevel(Level.ALL);
    LOGGER_CLASS_B.setLevel(Level.WARNING);
    LOGGER_ALL.setUseParentHandlers(false);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    LOGGER_ALL.addHandler(handler);
    handler.setFormatter(new XMLFormatter());
  }
}
