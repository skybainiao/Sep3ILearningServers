package com.example.ILearningServer.PostSystem;

import Model.LecturerAccount;
import RMIClient.Client;
import RMIClient.ClientImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@RestController
public class LecturerController
{
  private Gson gson;
  private Client client;

  public LecturerController() throws RemoteException, NotBoundException
  {
    gson = new Gson();
    client = new ClientImpl();
  }


  @PostMapping("/addLecturer")
  public void addLecturerAccount(@RequestBody String lecturerAccount)
      throws SQLException, RemoteException
  {
    LecturerAccount lecturerAccount1 = gson.fromJson(lecturerAccount,LecturerAccount.class);
    client.addLecturerAccount(lecturerAccount1);
  }


  @GetMapping("/getLecturer")
  public String getAllLecturerAccounts() throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getAllLecturerAccounts());
    return str;
  }



}
