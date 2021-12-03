package com.example.ILearningServer.PostSystem;

import RMIClient.Client;
import RMIClient.ClientImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
