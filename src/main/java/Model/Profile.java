package Model;

import java.io.Serializable;

public class Profile implements Serializable
{
  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private String phoneNumber;

  private String country;

  private String age;

  private String sex;

  public Profile(String username,String firstName,String lastName,String email,String phoneNumber,String country,String age,String sex){
    this.firstName=firstName;
    this.lastName=lastName;
    this.username=username;
    this.email=email;
    this.phoneNumber=phoneNumber;
    this.country=country;
    this.age=age;
    this.sex=sex;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getUsername()
  {
    return username;
  }

  public String getCountry()
  {
    return country;
  }

  public String getEmail()
  {
    return email;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setAge(String age)
  {
    this.age = age;
  }

  public String getAge()
  {
    return age;
  }

  public void setSex(String sex)
  {
    this.sex = sex;
  }

  public String getSex()
  {
    return sex;
  }

  @Override public String toString()
  {
    return "Profile{" + "firstName='" + firstName + '\'' + ", lastName='"
        + lastName + '\'' + ", username='" + username + '\'' + ", email='"
        + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", country='"
        + country + '\'' + ", age='" + age + '\'' + ", sex='" + sex + '\''
        + '}';
  }
}
