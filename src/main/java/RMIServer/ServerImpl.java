package RMIServer;

import Database.JDBC;
import Model.*;

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


  public void addLecturerAccount(LecturerAccount lecturerAccount) throws SQLException,RemoteException
  {
    jdbc.addLecturerAccount(lecturerAccount.getLecturerName(), lecturerAccount.getUsername(), lecturerAccount.getPassword());
  }


  public ArrayList<LecturerAccount> getAllLecturerAccounts() throws SQLException,RemoteException
  {
    ResultSet resultSet = jdbc.getAllLecturerAccount();
    ArrayList<LecturerAccount> lecturerAccounts = new ArrayList<>();

    try
    {
      while (resultSet.next()){
        String lecturerName = resultSet.getString(1);
        String username = resultSet.getString(2);
        String password = resultSet.getString(3);

        LecturerAccount lecturerAccount = new LecturerAccount(lecturerName,username,password);
        lecturerAccounts.add(lecturerAccount);

      }
    }
    catch (Exception e){
      e.printStackTrace();
    }

    return lecturerAccounts;
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


  public ArrayList<Message> getAllMessageByReceiver(String receiver) throws SQLException,RemoteException
  {
    ResultSet resultSet = jdbc.getAllMessage(receiver);
    ArrayList<Message> messages = new ArrayList<>();

    try
    {
      while (resultSet.next()){

        String sender = resultSet.getString("senderName");
        String receiverName = resultSet.getString("receiveName");
        String text = resultSet.getString("chatMessages");
        messages.add(new Message(sender,receiverName,text));

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


  public ArrayList<Request> getRequest(String username) throws SQLException,RemoteException
  {
    ResultSet resultSet = jdbc.getRequest(username);
    ArrayList<Request> requests = new ArrayList<>();

    try
    {
      while (resultSet.next()){
        String sender = resultSet.getString(1);
        String receiver = resultSet.getString(2);
        String comment = resultSet.getString(3);

        Request request = new Request(sender,receiver,comment);
        requests.add(request);

      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return requests;

  }


  public void addProfile(Profile profile) throws SQLException
  {
    jdbc.addProfile(profile.getUsername(), profile.getFirstName(),
        profile.getLastName(), profile.getEmail(), profile.getPhoneNumber(),
        profile.getCountry(),profile.getAge(), profile.getSex());
  }


  public ArrayList<Profile> getProfiles() throws SQLException
  {
    ResultSet resultSet = jdbc.getProfile();
    ArrayList<Profile> profiles = new ArrayList<>();

    try
    {
      while (resultSet.next()){

        String username1 = resultSet.getString(1);
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String email = resultSet.getString(4);
        String phoneNumber = resultSet.getString(5);
        String country = resultSet.getString(6);
        String age = resultSet.getString(7);
        String sex = resultSet.getString(8);

        Profile profile = new Profile(username1,firstName,lastName,email,phoneNumber,country,age,sex);

        profiles.add(profile);
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return profiles;

  }


  public void deleteProfile(String username) throws SQLException
  {
    jdbc.deleteProfile(username);
    System.out.println(jdbc.deleteProfile(username));
    System.out.println("uesd");
  }



}
