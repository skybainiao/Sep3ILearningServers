package Model;

public class Request
{
  private String sender;
  private String receiver;
  private String comment;

  public Request(String sender,String receiver,String comment){
    this.sender = sender;
    this.receiver = receiver;
    this.comment = comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }

  public void setReceiver(String receiver)
  {
    this.receiver = receiver;
  }

  public void setSender(String sender)
  {
    this.sender = sender;
  }

  public String getReceiver()
  {
    return receiver;
  }

  public String getComment()
  {
    return comment;
  }

  public String getSender()
  {
    return sender;
  }

  @Override public String toString()
  {
    return "Request{" + "sender='" + sender + '\'' + ", receiver='" + receiver
        + '\'' + ", comment='" + comment + '\'' + '}';
  }
}
