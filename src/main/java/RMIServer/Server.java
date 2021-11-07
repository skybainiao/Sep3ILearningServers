package RMIServer;

import Model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Server extends Remote
{
  void addUser(User user) throws RemoteException, SQLException;
  ArrayList<User> getAllUser() throws RemoteException, SQLException;

}
