package exercises.Uebung10;

import java.sql.*;
import java.util.Scanner;

public class Uebung10 {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:uebung10.sqlite")) {
      prepareDb(connection);

      createUsers(connection);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean saveUser(Connection connection, User user) {
    try (
      PreparedStatement checkUserNameUnique = connection.prepareStatement(
        "SELECT userName FROM users WHERE username = ?"
      )) {
      checkUserNameUnique.setString(1, user.getUserName());
      ResultSet statement = checkUserNameUnique.executeQuery();

      // if the name is already taken (next() returns true if the name exists), return false
      if (statement.next())
        return false;

      statement.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    try (PreparedStatement statement = connection.prepareStatement(
      "INSERT INTO users (userName, pwd, firstName, lastName) VALUES (?, ?, ?, ?)"
    )) {
      statement.setString(1, user.getUserName());
      statement.setString(2, user.getPwd());
      statement.setString(3, user.getLastName());
      statement.setString(4, user.getFirstName());

      statement.execute();

      return true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void createUsers(Connection connection) {
    Scanner scanner = new Scanner(System.in);
    String text;
    System.out.println("Please enter a new user's details (comma separated) or type 'quit'");
    System.out.print("Details (userName, pwd, lastName, firstName): ");
    while (!(text = scanner.nextLine()).equals("quit")) {
      String[] details = text.split(", ");

      User user = new User(details[0], details[1], details[2], details[3]);

      boolean successfullyAdded = saveUser(connection, user);
      if (!successfullyAdded) {
        System.out.println("User with name '" + user.getUserName() + "' already exists");
      } else {
        System.out.println("User added to database: " + user);
      }

      System.out.println("Users:\n");
      printUsers(connection);

      System.out.println("Please enter a new user's details (comma separated) or type 'quit'");
      System.out.print("Details (userName, pwd, lastName, firstName): ");
    }
  }

  private static void printUsers(Connection connection) {
    try (PreparedStatement statement = connection.prepareStatement(
      "SELECT * FROM users"
    ); ResultSet resultSet = statement.executeQuery()) {
      while (resultSet.next()) {
        System.out.println(
          new User(
            resultSet.getString("userName"),
            resultSet.getString("pwd"),
            resultSet.getString("lastName"),
            resultSet.getString("firstName")
          )
        );
      }
      System.out.println();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void prepareDb(Connection connection) throws SQLException {
    PreparedStatement statement = connection.prepareStatement(
      "CREATE TABLE IF NOT EXISTS 'users' (userName VARCHAR(255) PRIMARY KEY, pwd VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255))"
    );

    statement.execute();
    statement.close();
  }
}
