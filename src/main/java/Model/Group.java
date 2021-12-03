package Model;

import java.io.Serializable;

public class Group implements Serializable
{
  private String groupName;
  private String memberName;

  public Group(String groupName,String memberName){
    this.groupName=groupName;
    this.memberName=memberName;
  }

  public void setMemberName(String memberName)
  {
    this.memberName = memberName;
  }

  public String getMemberName()
  {
    return memberName;
  }

  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }

  public String getGroupName()
  {
    return groupName;
  }

  @Override public String toString()
  {
    return "Group{" + "groupName='" + groupName + '\'' + ", memberName='"
        + memberName + '\'' + '}';
  }
}
