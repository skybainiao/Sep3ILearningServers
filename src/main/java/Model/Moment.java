package Model;

public class Moment
{
  private String username;

  private String time;

  private String imageUrl;

  private String context;

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setContext(String context)
  {
    this.context = context;
  }

  public void setImageUrl(String imageUrl)
  {
    this.imageUrl = imageUrl;
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

  public String getImageUrl()
  {
    return imageUrl;
  }

  public String getTime()
  {
    return time;
  }

  @Override public String toString()
  {
    return "Moment{" + "username='" + username + '\'' + ", time='" + time + '\''
        + ", imageUrl='" + imageUrl + '\'' + ", context='" + context + '\''
        + '}';
  }
}
