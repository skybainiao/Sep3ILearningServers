package RMIServer;

import Model.Message;
import Model.User;

import java.lang.reflect.Member;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Server extends Remote
{
  void addUser(User user) throws RemoteException, SQLException;
  ArrayList<User> getAllUser() throws RemoteException, SQLException;
  void sendMessage(String senderName,String receiveName,String text) throws SQLException,RemoteException;
  ArrayList<Message> getAllMessage(String senderName, String receiveName) throws SQLException,RemoteException;
  ArrayList<User> getAllFriends(String username) throws SQLException,RemoteException;
  void increase(String username) throws SQLException,RemoteException;
  int getNum(String username) throws SQLException,RemoteException;
  void addFriend(String username,String friendName) throws SQLException,RemoteException;
  void clearMessageNum(String username) throws SQLException,RemoteException;
  void sendFriendRequest(String sender,String receiver,String comment) throws SQLException,RemoteException;


}
