package RMIClient;

import Model.User;
import RMIServer.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientImpl implements Client
{
  private Server server;

  public ClientImpl() throws RemoteException, NotBoundException
  {
    UnicastRemoteObject.exportObject(this,0);
    Registry registry = LocateRegistry.getRegistry("localhost",6666);
    server = (Server) registry.lookup("Server");
  }

  public ArrayList<User> getAllUsers() throws RemoteException, SQLException
  {
    return server.getAllUser();
  }

  public void addUser(User user) throws RemoteException, SQLException
  {
    server.addUser(user);
    System.out.println("client add");
  }


}
