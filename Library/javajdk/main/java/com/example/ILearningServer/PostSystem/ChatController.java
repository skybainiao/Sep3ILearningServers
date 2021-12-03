package com.example.ILearningServer.PostSystem;

import RMIClient.Client;
import RMIClient.ClientImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;


@RestController
public class ChatController
{

  private Gson gson = new Gson();
  private Client client;

  public ChatController() throws RemoteException, NotBoundException
  {
    client = new ClientImpl();
  }


  @PostMapping("/send")
  public void sendMessage(@RequestBody String sender,String receiver,String text) throws SQLException, RemoteException
  {
    client.sendMessage(sender,receiver,text);
    System.out.println(sender+receiver+text);
  }


  @GetMapping("/Messages")
  public String getMessages(String sender,String receiver) throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getAllMessage(sender, receiver));
    System.out.println(str);

    return str;
  }

  @GetMapping("/getAllMessages")
  public String getAllMessages(@RequestParam String receiver)
      throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getAllMessageByReceiver(receiver));
    return str;
  }


  @GetMapping("/unreadNum")
  public int getNum(String username) throws SQLException, RemoteException
  {
    return client.getNum(username);
  }


  @PostMapping("/clear")
  public void clear(String username) throws SQLException, RemoteException
  {
    client.clearMessageNum(username);
  }








}
