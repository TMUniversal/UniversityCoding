package exercises.Uebung10JPA;

import org.apache.openjpa.persistence.OpenJPAEntityManager;
import org.apache.openjpa.persistence.OpenJPAEntityManagerFactory;
import org.apache.openjpa.persistence.OpenJPAPersistence;

import javax.persistence.EntityTransaction;
import java.util.*;

public class Uebung10Jpa {
  private static final Map<String, String> config = new HashMap<>();

  public static void main(String[] args) {
    config.put("openjpa.ConnectionURL", "jdbc:mysql://" + System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME"));
    config.put("openjpa.ConnectionDriverName", "com.mysql.cj.jdbc.Driver");
    config.put("openjpa.ConnectionUserName", System.getenv("DB_USER"));
    config.put("openjpa.ConnectionPassword", System.getenv("DB_PASS"));
    config.put("openjpa.RuntimeUnenhancedClasses", "supported");
    config.put("openjpa.jdbc.SynchronizeMappings", "add");

    List<Class<?>> classes = new ArrayList<>();

    classes.add(User.class);

    if (!classes.isEmpty()) {
      StringBuilder sb = new StringBuilder();

      for (Class<?> c : classes) {
        if (sb.length() > 0) {
          sb.append(";");
        }

        sb.append(c.getName());
      }

      config.put("openjpa.MetaDataFactory", "jpa(Types=" + sb + ")");
    }

    OpenJPAEntityManagerFactory managerFactory = OpenJPAPersistence.getEntityManagerFactory(config);
    OpenJPAEntityManager entityManager = managerFactory.createEntityManager();


    Scanner scanner = new Scanner(System.in);

    System.out.print("You now have the option to exit the program (exit): ");
    if (scanner.nextLine().equals("exit")) return;

    System.out.print("Please enter the details for a new user (username, password, first name, last name): ");
    String line = scanner.nextLine();

    User user = new User(line.split(","));

    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(user);
    transaction.commit();
  }
}
