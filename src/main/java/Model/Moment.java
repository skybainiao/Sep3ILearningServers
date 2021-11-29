package Model;

import java.io.Serializable;

public class Moment implements Serializable
{
  private String username;

  private String time;

  private String content;

  private int like;

  private int dislike;

  public Moment(String username,String time,String content,int like,int dislike){
    this.username = username;
    this.time = time;
    this.content = content;
    this.like = like;
    this.dislike = dislike;
  }

  public void setDislike(int dislike)
  {
    this.dislike = dislike;
  }

  public void setLike(int like)
  {
    this.like = like;
  }

  public int getDislike()
  {
    return dislike;
  }

  public int getLike()
  {
    return like;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setContext(String context)
  {
    this.content = context;
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
    return content;
  }

  public String getTime()
  {
    return time;
  }

  @Override public String toString()
  {
    return "Moment{" + "username='" + username + '\'' + ", time='" + time + '\''
        + ", context='" + content + '\'' + ", like=" + like + ", dislike="
        + dislike + '}';
  }
}
