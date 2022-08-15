package exercises.Uebung10JPA;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
  @Id
  private String userName;
  private String pwd;
  private String firstName;
  private String lastName;

  public User() {
  }

  public User(String userName, String pwd, String firstName, String lastName) {
    this.userName = userName;
    this.pwd = pwd;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public User(String[] details) {
    this(details[0].trim(), details[1].trim(), details[2].trim(), details[3].trim());
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "User{" +
      "userName='" + userName + '\'' +
      ", pwd='" + pwd + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
