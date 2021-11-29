package Model;

public class Course
{


  private String courseName;
  private String session;
  private String date;
  private String preparation;
  private String content;

  public Course(String courseName,String session,String date,String preparation,String content){
    this.courseName=courseName;
    this.session=session;
    this.date=date;
    this.preparation=preparation;
    this.content=content;


  }

  public void setContent(String content)
  {
    this.content = content;

  }

  public String getContent()
  {
    return content;
  }

  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public void setPreparation(String preparation)
  {
    this.preparation = preparation;
  }

  public void setSession(String session)
  {
    this.session = session;
  }

  public String getCourseName()
  {
    return courseName;
  }

  public String getDate()
  {
    return date;
  }

  public String getPreparation()
  {
    return preparation;
  }

  public String getSession()
  {
    return session;
  }

  @Override public String toString()
  {
    return "Course{" + "courseName='" + courseName + '\'' + ", session='"
        + session + '\'' + ", date='" + date + '\'' + ", preparation='"
        + preparation + '\'' + '}';
  }
}
