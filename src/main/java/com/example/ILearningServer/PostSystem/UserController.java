package com.example.ILearningServer.PostSystem;

import Model.*;
import RMIClient.Client;
import RMIClient.ClientImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@RestController
public class UserController
{

  private Gson gson;
  private Greeting greeting = new Greeting("Chen");
  private Client client;

  public UserController() throws RemoteException, NotBoundException
  {
    gson = new Gson();
    client = new ClientImpl();
  }


  @GetMapping("/greeting")
  public String greeting() {
    System.out.println("get");
    return greeting.toString();
  }


  @GetMapping("/getUser")
  public String getAllUsers() throws RemoteException, SQLException
  {
    String str = gson.toJson(client.getAllUsers());
    return str;
  }


  @PostMapping("/user")
  public void addUser(@RequestBody String user) throws RemoteException, SQLException
  {
    User user1 = gson.fromJson(user,User.class);
    client.addUser(user1);
    System.out.println(user1);
  }


  @GetMapping("/getFriends")
  public String getAllFriends(@RequestParam String username) throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getAllFriends(username));

    return str;

  }


  @PostMapping("/addFriend")
  public void addFriend(@RequestBody String username,String friendName) throws SQLException, RemoteException
  {
    client.addFriend(username,friendName);
    System.out.println("Added a new friend");
  }


  @PostMapping("/sendRequest")
  public void sendFriendRequest(@RequestBody Request request) throws SQLException, RemoteException
  {
      client.sendFriendRequest(request.getSender(), request.getReceiver(), request.getComment());
      System.out.println(request.getSender()+""+request.getReceiver()+""+request.getComment());
  }


  @PostMapping("/addProfile")
  public void addProfile(@RequestBody String profile)
      throws SQLException, RemoteException
  {
    Profile profile1 = gson.fromJson(profile,Profile.class);
    client.addProfile(profile1);
  }


  @GetMapping("/getProfile")
  public String getProfile() throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getProfiles());

    return str;
  }


  @PostMapping("/deleteProfile")
  public void deleteProfile(@RequestBody String username)
      throws SQLException, RemoteException
  {
    client.deleteProfile(username);
    System.out.println(username);
  }


  @GetMapping("/getRequest")
  public String getRequest(@RequestParam String username) throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getRequest(username));

    return str;
  }


  @PostMapping("/deleteRequest")
  public void delete(@RequestBody String sender,String receiver) throws SQLException, RemoteException
  {
    client.deleteRequest(sender, receiver);
  }


  @GetMapping("/getMoments")
  public String getMoments() throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getAllMoments());

    return str;
  }


  @PostMapping("/addMoment")
  public void addMoment(@RequestBody String moment)
      throws SQLException, RemoteException
  {
    Moment moment1 = gson.fromJson(moment,Moment.class);

    client.addMoment(moment1);
  }


  @PostMapping("/like")
  public void like(@RequestBody String username)
      throws SQLException, RemoteException
  {
    client.like(username);
  }


  @PostMapping("/dislike")
  public void dislike(@RequestBody String username)
      throws SQLException, RemoteException
  {
    client.dislike(username);
  }








}
