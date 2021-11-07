package RMIServer;

import Database.JDBC;
import Model.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerImpl implements Server
{
  private JDBC jdbc;

  public ServerImpl() throws Exception{
    Registry registry = LocateRegistry.createRegistry(6666);
    registry.bind("Server",this);
    UnicastRemoteObject.exportObject(this,6666);
    jdbc = new JDBC();

  }

  public void addUser(User user) throws SQLException
  {

    jdbc.addUser(user.getUsername(), user.getPassword());
    System.out.println("Server added a user : "+user);

  }


  public ArrayList<User> getAllUser() throws SQLException
  {
    ResultSet resultSet = jdbc.getAllUsers();
    ArrayList<User> users = new ArrayList<>();

    try
    {
      while (resultSet.next()){

        String username = resultSet.getString("username");
        String password = resultSet.getString("password");

        User user = new User(username,password);
        users.add(user);

      }

    }
    catch (Exception e){
      e.printStackTrace();
    }

    return users;

  }


}
