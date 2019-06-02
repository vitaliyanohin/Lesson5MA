public class MainApplication {

  private boolean setConnection = false;
  private RobotConnectionManager robotConnectionManager = new RobotConnectionManager() {
    @Override
    public void close() {
      System.out.println("System: Connection close!");
    }

    @Override
    public void getConnection() {
      System.out.println("System: Connection done! ");
    }
  };
  private RobotConnection robotConnection = new RobotConnection() {
    @Override
    public RobotConnection moveRobotTo(int x, int y) {
      System.out.println("Robot: course set!");
      return null;
    }

    @Override
    public void close() {
    }
  };


  public static void main(String[] args) {
    MainApplication application = new MainApplication();
    Logging.configureLogging();
    application.moveRobot(2, 2);
  }

  private void moveRobot(int toX, int toY) {
    int i = 0;
    while (!setConnection && (i <= 3)) {
      try {
        while (i < 3) {
          throw new RobotConnectionException("System: no connection....");
        }
        robotConnectionManager.getConnection();
        setConnection = true;
        robotConnection.moveRobotTo(toX, toY);
        robotConnectionManager.close();
      } catch (RobotConnectionException e) {
        i++;

        if (i == 4) {
          throw new RobotConnectionException("System: Connection Fail", e);
        }
        System.out.println("System: Connection Attempt... №" + i);
      }
    }
  }
}
