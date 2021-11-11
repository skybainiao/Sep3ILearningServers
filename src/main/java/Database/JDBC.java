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


  public int sendMessage(String senderName,String receiveName,String text) throws SQLException {

    String sql="insert into sep3data.Message(senderName,receiveName,chatMessages)\n" + "values(?,?,?)";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1, senderName);
    preparedStatement.setString(2, receiveName);
    preparedStatement.setString(3,text);

    return preparedStatement.executeUpdate();
  }


  public ResultSet getMessage(String senderName,String receiveName) throws SQLException {
    String sql="select chatMessages\n" + "from sep3data.Message\n" +
        "where senderName = ? and receiveName = ?\n" +
        "or senderName = ? and receiveName = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,senderName);
    preparedStatement.setString(2,receiveName);
    preparedStatement.setString(3,receiveName);
    preparedStatement.setString(4,senderName);

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



}
