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





}
