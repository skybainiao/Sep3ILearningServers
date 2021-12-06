package com.example.ILearningServer.PostSystem;

import Model.Group;
import RMIClient.Client;
import RMIClient.ClientImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@RestController
public class GroupController
{

  private Gson gson;
  private Client client;

  public GroupController() throws RemoteException, NotBoundException
  {
    gson = new Gson();
    client = new ClientImpl();
  }


  @GetMapping("/getGroups")
  public String getGroups() throws SQLException, RemoteException
  {
    String str = gson.toJson(client.groups());

    return str;
  }


  @GetMapping("/getGroupName")
  public String getGroupName() throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getGroupName());

    return str;
  }


  @GetMapping("/getGroupMember")
  public String getGroupMember(@RequestParam String username) throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getGroupMember(username));

    return str;
  }


  @PostMapping("/addGroup")
  public void addGroup(@RequestBody String group) throws SQLException, RemoteException
  {
    Group group1 = gson.fromJson(group,Group.class);
    client.addGroup(group1);
  }


}
