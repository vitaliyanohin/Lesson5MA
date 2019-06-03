public class MainApplication {

  public static void main(String[] args) {
    Logging.configureLogging();
  }

  public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws RobotConnectionException {
    int counter = 0;
    RobotConnection robotConnection = null;
    while (counter < 3) {
      try {
        robotConnection = robotConnectionManager.getConnection();
        robotConnection.moveRobotTo(toX, toY);
        counter = 3;
      } catch (RobotConnectionException e) {
        System.out.println("System: Connection Attempt... №" + counter);
        counter++;
        if (counter == 3) {
          throw new RobotConnectionException("System: Connection Fail", e);
        }
      } finally {
        try {
          robotConnection.close();
        } catch (Exception ex) {
        }
      }
    }
  }
}


