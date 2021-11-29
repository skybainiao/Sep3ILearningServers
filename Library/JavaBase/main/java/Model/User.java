package Model;

import java.io.Serializable;

public class User implements Serializable
{

  private String Username;
  private String Password;

  public User(String username,String password){
    this.Username=username;
    this.Password=password;
  }

  public void setPassword(String password)
  {
    this.Password = password;
  }

  public void setUsername(String username)
  {
    this.Username = username;
  }

  public String getPassword()
  {
    return Password;
  }

  public String getUsername()
  {
    return Username;
  }

  @Override public String toString()
  {
    return "User{" + "username='" + Username + '\'' + ", password='" + Password
        + '\'' + '}';
  }
}
