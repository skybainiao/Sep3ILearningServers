package com.example.ILearningServer.PostSystem;

import RMIClient.Client;
import RMIClient.ClientImpl;
import Model.Greeting;
import Model.User;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@RestController
public class UserController
{

  private Gson gson = new Gson();
  private Greeting greeting = new Greeting("Chen");
  private Client client;

  public UserController() throws RemoteException, NotBoundException
  {
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
  }










}
