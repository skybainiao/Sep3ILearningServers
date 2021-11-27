package Database;

import java.sql.*;

public class JDBC {

  private static String driver = "org.postgresql.Driver";
  private static String url = "jdbc:postgresql://localhost:5432/postgres";
  private static String user = "postgres";
  private static String password = "cjj2468830035";
  private Connection connection;

  public JDBC() throws ClassNotFoundException, SQLException
  {
    Class.forName(driver);
    connection = DriverManager.getConnection(url,user,password);
    System.out.println("Connected to database : "+connection.getCatalog());
  }


  public int addUser(String username,String password) throws SQLException
  {
    String sql = "insert into sep3data.SimpleUser(username,password)\n" + "values (?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);
    preparedStatement.setString(2,password);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getAllUsers() throws SQLException
  {
    String sql = "select * from sep3data.SimpleUser";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    return preparedStatement.executeQuery();
  }


  public int addLecturerAccount(String LecturerName,String username,String password) throws SQLException
  {
    String sql = "insert into sep3data.LecturerAccount(lecturerName, username, password)\n" + "values (?,?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,LecturerName);
    preparedStatement.setString(2,username);
    preparedStatement.setString(3,password);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getAllLecturerAccount() throws SQLException
  {
    String sql = "select * from sep3data.LecturerAccount";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    return preparedStatement.executeQuery();
  }


  public int sendMessage(String senderName,String receiveName,String text) throws SQLException {

    String sql="insert into sep3data.Message(senderName,receiveName,chatMessages)\n" + "values(?,?,?)";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1, senderName);
    preparedStatement.setString(2, receiveName);
    preparedStatement.setString(3,text);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getMessage(String senderName,String receiveName) throws SQLException {
    String sql="select *\n" + "from sep3data.Message\n" +
        "where senderName = ? and receiveName = ?\n" +
        "or senderName = ? and receiveName = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,senderName);
    preparedStatement.setString(2,receiveName);
    preparedStatement.setString(3,receiveName);
    preparedStatement.setString(4,senderName);

    return preparedStatement.executeQuery();
  }


  public ResultSet getAllMessage(String receiver) throws SQLException
  {
    String sql = "select *\n" + "from sep3data.Message\n" + "where receiveName = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,receiver);

    return preparedStatement.executeQuery();
  }


  public ResultSet getFriends(String username) throws SQLException {
    String sql="select friendName from sep3data.Friend where username = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);

    return preparedStatement.executeQuery();
  }
  public int increase(String username) throws SQLException {
    String sql="update sep3data.SimpleUser set receiveMessageNum = receiveMessageNum+1 where username = ?";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1,username);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getUnreadNum(String username) throws SQLException
  {
    String sql = "select receiveMessageNum\n" + "from sep3data.SimpleUser\n" + "where username = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, username);

    return preparedStatement.executeQuery();
  }


  public int addFriend(String username,String fiendName) throws SQLException
  {
    String sql = "insert into sep3data.Friend(username, friendName)\n" + "values (?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);
    preparedStatement.setString(2,fiendName);

    return preparedStatement.executeUpdate();
  }


  public int clearMessage(String username) throws SQLException
  {
    String sql = "update sep3data.SimpleUser set receiveMessageNum = 0 where username = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);
    return preparedStatement.executeUpdate();

  }


  public int sendFriendRequest(String sender,String receiver,String comment) throws SQLException
  {
    String sql = "insert into sep3data.FriendRequest(sender, receiver, comment)\n" + "values (?,?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,sender);
    preparedStatement.setString(2,receiver);
    preparedStatement.setString(3,comment);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getRequest(String username) throws SQLException
  {
    String sql = "select * from sep3data.FriendRequest where receiver = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);

    return preparedStatement.executeQuery();
  }


  public int addProfile(String username,String firstName,String lastName,String email,String phoneNumber,String country,String age,String sex) throws SQLException
  {
    String sql = "insert into sep3data.Profile(username, firstName, lastName, email, phoneNumber, country,age,sex)\n" + "values (?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);
    preparedStatement.setString(2,firstName);
    preparedStatement.setString(3,lastName);
    preparedStatement.setString(4,email);
    preparedStatement.setString(5,phoneNumber);
    preparedStatement.setString(6,country);
    preparedStatement.setString(7,age);
    preparedStatement.setString(8,sex);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getProfile() throws SQLException
  {
    String sql = "select * from sep3data.Profile";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    return preparedStatement.executeQuery();
  }


  public int deleteProfile(String username) throws SQLException
  {
    String sql = "delete from sep3data.Profile where username = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,username);

    return preparedStatement.executeUpdate();
  }




}
