package Model;

public class Moment
{
  private String username;

  private String time;

  private String context;

  public Moment(String username,String time,String context){
    this.username = username;
    this.time = time;
    this.context = context;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setContext(String context)
  {
    this.context = context;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public String getUsername()
  {
    return username;
  }

  public String getContext()
  {
    return context;
  }

  public String getTime()
  {
    return time;
  }

  @Override public String toString()
  {
    return "Moment{" + "username='" + username + '\'' + ", time='" + time + '\''
        + ", context='" + context + '\'' + '}';
  }
}
