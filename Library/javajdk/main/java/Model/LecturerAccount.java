package Model;

import java.io.Serializable;

public class LecturerAccount implements Serializable
{

  private String LecturerName;
  private String Username;
  private String Password;

  public LecturerAccount(String username,String password,String lecturerName){
    this.Username=username;
    this.Password=password;
    this.LecturerName=lecturerName;
  }

  public String getUsername()
  {
    return Username;
  }

  public String getPassword()
  {
    return Password;
  }

  public void setUsername(String username)
  {
    Username = username;
  }

  public void setPassword(String password)
  {
    Password = password;
  }

  public String getLecturerName()
  {
    return LecturerName;
  }

  public void setLecturerName(String lecturerName)
  {
    LecturerName = lecturerName;
  }

  @Override public String toString()
  {
    return "LecturerAccount{" + "LecturerName='" + LecturerName + '\''
        + ", Username='" + Username + '\'' + ", Password='" + Password + '\''
        + '}';
  }
}
