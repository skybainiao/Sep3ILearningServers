package Model;

public class Profile
{

  private String firstName;

  private String lastName;

  private String username;

  private String email;

  private String phoneNumber;

  private String country;

  public Profile(String firstName,String lastName,String username,String email,String phoneNumber,String country){
    this.firstName=firstName;
    this.lastName=lastName;
    this.username=username;
    this.email=email;
    this.phoneNumber=phoneNumber;
    this.country=country;
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

  @Override public String toString()
  {
    return "Profile{" + "firstName='" + firstName + '\'' + ", lastName='"
        + lastName + '\'' + ", username='" + username + '\'' + ", email='"
        + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", country='"
        + country + '\'' + '}';
  }


}
