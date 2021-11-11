package Model;

public class Message
{
  private String senderName;
  private String receiverName;
  private String chatMessages;

  public Message(String senderName,String receiverName,String chatMessages){
    this.senderName = senderName;
    this.receiverName = receiverName;
    this.chatMessages = chatMessages;
  }

  public void setChatMessages(String chatMessages)
  {
    this.chatMessages = chatMessages;
  }

  public void setReceiverName(String receiverName)
  {
    this.receiverName = receiverName;
  }

  public void setSenderName(String senderName)
  {
    this.senderName = senderName;
  }

  public String getChatMessages()
  {
    return chatMessages;
  }

  public String getReceiverName()
  {
    return receiverName;
  }

  public String getSenderName()
  {
    return senderName;
  }

  @Override public String toString()
  {
    return "Message{" + "senderName='" + senderName + '\'' + ", receiverName='"
        + receiverName + '\'' + ", chatMessages='" + chatMessages + '\'' + '}';
  }
}
