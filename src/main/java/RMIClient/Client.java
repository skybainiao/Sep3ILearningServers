package RMIClient;

import Model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Client extends Remote
{

  ArrayList<User> getAllUsers() throws RemoteException, SQLException;
  void addUser(User user) throws RemoteException, SQLException;
  void sendMessage(String senderName,String receiveName,String text) throws SQLException,RemoteException;
  ArrayList<String> getAllMessage(String senderName, String receiveName) throws SQLException,RemoteException;
  ArrayList<User> getAllFriends(String username) throws SQLException,RemoteException;
  void increase(String username) throws SQLException,RemoteException;
  int getNum(String username) throws SQLException,RemoteException;




}
