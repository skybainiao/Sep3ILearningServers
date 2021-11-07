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





}
