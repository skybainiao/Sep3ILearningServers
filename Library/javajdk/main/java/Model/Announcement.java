package Model;

import java.io.Serializable;

public class Announcement implements Serializable
{

  private String courseName;
  private String LecturerName;
  private String time;
  private String content;


  public Announcement(String courseName,String lecturerName,String time,String content){
    this.courseName=courseName;
    this.LecturerName=lecturerName;
    this.time=time;
    this.content=content;
  }

  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }

  public void setLecturerName(String lecturerName)
  {
    LecturerName = lecturerName;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public String getCourseName()
  {
    return courseName;
  }

  public String getLecturerName()
  {
    return LecturerName;
  }

  public String getTime()
  {
    return time;
  }

  public String getContent()
  {
    return content;
  }

  @Override public String toString()
  {
    return "Announcement{" + "courseName='" + courseName + '\''
        + ", LecturerName='" + LecturerName + '\'' + ", time='" + time + '\''
        + ", content='" + content + '\'' + '}';
  }
}
