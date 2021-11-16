package RMIServer;

import Database.JDBC;
import Model.Message;
import Model.User;

import javax.swing.*;
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


  public void sendMessage(String senderName,String receiveName,String text) throws SQLException,RemoteException {
    jdbc.sendMessage(senderName,receiveName,text);
  }


  public ArrayList<Message> getAllMessage(String senderName, String receiveName) throws SQLException,RemoteException{
    ResultSet rs = jdbc.getMessage(senderName,receiveName);
    ArrayList<Message> messages = new ArrayList<>();

    try {
      while (rs.next()){

        String sender = rs.getString("senderName");
        String receiver = rs.getString("receiveName");
        String text = rs.getString("chatMessages");
        messages.add(new Message(sender,receiver,text));

      }
    }
    catch (Exception e){
      e.printStackTrace();
    }

    return messages;
  }


  public ArrayList<User> getAllFriends(String username) throws SQLException,RemoteException{
    ResultSet rs = jdbc.getFriends(username);
    ArrayList<User> users = new ArrayList<>();

    try {
      while (rs.next()){
        String friendName = rs.getString("friendName");

        for (int i = 0; i < getAllUser().size(); i++)
        {
          if (getAllUser().get(i).getUsername().equals(friendName)){
            users.add(getAllUser().get(i));
          }
        }

      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return users;

  }


  public void increase(String username) throws SQLException,RemoteException{
    jdbc.increase(username);
  }



  public int getNum(String username) throws SQLException,RemoteException {
    ResultSet rs = jdbc.getUnreadNum(username);
    int num = 0;

    try {
      while (rs.next()){
        int unread = rs.getInt("receiveMessageNum");

        num = unread;
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return num;
  }


  public void addFriend(String username,String friendName) throws SQLException
  {
    jdbc.addFriend(username,friendName);
  }


  public void clearMessageNum(String username) throws SQLException
  {
    jdbc.clearMessage(username);
  }


  public void sendFriendRequest(String sender,String receiver,String comment) throws SQLException
  {
    try
    {
      jdbc.sendFriendRequest(sender, receiver, comment);
    }
    catch (Exception e){
      System.out.println("you already send request");
      JOptionPane.showMessageDialog(null,"you already send request","Tip",JOptionPane.ERROR_MESSAGE);
    }

  }



}
