package bonusTasks.task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonusTask5 {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:media.sqlite")) {
      prepareDb(connection);

      Scanner scanner = new Scanner(System.in);
      String userInput;

      System.out.print("Please enter an action (print/add/delete/quit): ");
      while (!(userInput = scanner.nextLine()).equals("quit")) {
        if (userInput.equals("add")) {
          System.out.print("Please enter the movie's title, director, publishing year: ");
          String[] details = scanner.nextLine().split(",");

          if (details.length < 3) {
            System.out.println("Please enter all three fields, separated by a `,`");
            continue;
          }

          if (!details[2].trim().matches("\\d+")) {
            System.out.printf("Year must be a number! (read '%s')\n", details[2].trim());
            continue;
          }

          MediaDisk disk = new MediaDisk(-1, details[0].trim(), details[1].trim(), Integer.parseInt(details[2].trim()));
          System.out.println("You entered: " + disk);

          System.out.println("Saved?: " + saveDisk(connection, disk));
        } else if (userInput.equals("delete")) {
          System.out.println("The following disks are in the database:");
          printDisks(connection);

          System.out.print("Please enter the id number of the disk you wish to delete: ");
          String i = scanner.nextLine();

          if (!i.matches("\\d+")) {
            System.out.println("ID must be a number!");
            continue;
          }

          System.out.println("Deleted?: " + removeDisk(connection, Integer.parseInt(i)));
        } else if (userInput.equals("print")) {
          printDisks(connection);
        } else {
          System.out.println("Unknown command.");
        }

        System.out.print("Please enter an action (print/add/delete/quit): ");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void printDisks(Connection connection) {
    List<MediaDisk> disks = getDisks(connection);

    if (disks.isEmpty()) {
      System.out.println("No disks in database.");
    }

    for (MediaDisk disk : disks) {
      System.out.println(disk);
    }
  }

  private static List<MediaDisk> getDisks(Connection connection) {
    try (PreparedStatement statement = connection.prepareStatement(
      "SELECT * FROM disks"
    )) {
      ResultSet resultSet = statement.executeQuery();

      List<MediaDisk> disks = new ArrayList<>();
      while (resultSet.next()) {
        disks.add(new MediaDisk(
          resultSet.getInt("id"),
          resultSet.getString("title"),
          resultSet.getString("director"),
          resultSet.getInt("year")
        ));
      }

      return disks;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean saveDisk(Connection connection, MediaDisk disk) {
    if (getDisk(connection, disk.getId()) != null) return false;

    try (PreparedStatement statement = connection.prepareStatement(
      "INSERT INTO disks (title, director, year) VALUES (?, ?, ?)"
    )) {
      statement.setString(1, disk.getTitle());
      statement.setString(2, disk.getDirector());
      statement.setInt(3, disk.getPublishYear());

      return !statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  private static boolean removeDisk(Connection connection, int id) {
    if (getDisk(connection, id) == null) return false;

    try (PreparedStatement statement = connection.prepareStatement(
      "DELETE FROM disks WHERE id = ?"
    )) {
      statement.setInt(1, id);
      return !statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static MediaDisk getDisk(Connection connection, int id) {
    try (PreparedStatement statement = connection.prepareStatement(
      "SELECT * FROM disks WHERE id = ?"
    )) {
      statement.setInt(1, id);

      ResultSet resultSet = statement.executeQuery();

      if (!resultSet.next()) return null;

      return new MediaDisk(
        resultSet.getInt("id"),
        resultSet.getString("title"),
        resultSet.getString("director"),
        resultSet.getInt("year")
      );
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void prepareDb(Connection connection) {
    try (PreparedStatement statement = connection.prepareStatement(
      "CREATE TABLE IF NOT EXISTS disks (id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(255), director VARCHAR(255), year INTEGER)"
    )) {
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
