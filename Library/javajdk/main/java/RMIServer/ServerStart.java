package RMIServer;

public class ServerStart
{
  public static void main(String[] args) throws Exception
  {
    Server server = new ServerImpl();
    System.out.println(server.hashCode());
  }
}
