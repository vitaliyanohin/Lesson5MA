public interface RobotConnection extends AutoCloseable  {

  RobotConnection moveRobotTo( int x, int y);
  @Override
  void close();

}
