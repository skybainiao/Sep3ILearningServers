package Model;

import java.io.Serializable;

public class Greeting implements Serializable
{

  private final String content;

  public Greeting(String content) {

    this.content = content;
  }


  public String getContent() {
    return content;
  }

  @Override public String toString()
  {
    return "Greeting{" + "content='" + content + '\'' + '}';
  }

}
