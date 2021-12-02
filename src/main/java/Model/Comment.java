package Model;

import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Comment implements Serializable
{
  private String username;
  private String publisher;
  private String content;
  private String time;

  public Comment(String username, String publisher,String content,String time){
    this.username = username;
    this.publisher = publisher;
    this.content = content;
    this.time = time;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }

  public String getTime()
  {
    return time;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getContent()
  {
    return content;
  }

  public String getUsername()
  {
    return username;
  }

  @Override public String toString()
  {
    return "Comment{" + "username='" + username + '\'' + ", publisher='"
        + publisher + '\'' + ", content='" + content + '\'' + ", time='" + time
        + '\'' + '}';
  }
}
