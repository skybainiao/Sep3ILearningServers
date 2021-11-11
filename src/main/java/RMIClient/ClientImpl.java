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


  @Override
  public ArrayList<User> getAllUsers() throws RemoteException, SQLException
  {
    return server.getAllUser();
  }


  @Override
  public void addUser(User user) throws RemoteException, SQLException
  {
    server.addUser(user);
    System.out.println("client add");
  }


  @Override
  public void sendMessage(String senderName, String receiveName, String text) throws SQLException, RemoteException
  {
    server.sendMessage(senderName,receiveName,text);
  }


  @Override
  public ArrayList<String> getAllMessage(String senderName, String receiveName) throws SQLException, RemoteException
  {
    return server.getAllMessage(senderName,receiveName);
  }


  @Override
  public ArrayList<User> getAllFriends(String username) throws SQLException, RemoteException
  {
    return server.getAllFriends(username);
  }


  @Override
  public void increase(String username) throws SQLException, RemoteException
  {
    server.increase(username);
  }


  @Override
  public int getNum(String username) throws SQLException, RemoteException
  {
    return server.getNum(username);
  }


  @Override public void addFriend(String username, String friendName) throws SQLException, RemoteException
  {
    server.addFriend(username,friendName);
  }


  @Override public void clearMessageNum(String username) throws SQLException, RemoteException
  {
    server.clearMessageNum(username);
  }

}
