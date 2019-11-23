package tomsh;

import java.time.DateTimeException;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public class Employee {
  @SuppressWarnings("CanBeFinal")
  private StringBuilder name;
  private String username;
  private String password;
  private String email;
  private String deptId;
  private long lastAttempt;

  /**
   * Constructs an employee's account, generating a username from their name.
   *
   * @param name The employee's name
   * @param password Their password
   * @param id Their id, which is unique
   * @throws IllegalArgumentException throws when
   */
  public Employee(String name, String password, int id) throws IllegalArgumentException {
    this.name = new StringBuilder(name);
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      throw new IllegalArgumentException();
    }
    setDeptId(id);
    lastAttempt = 0;
  }

  private void setUsername(String name) {
    username = "" + name.charAt(0);
    username += name.substring(name.indexOf(" ") + 1);
    username = username.toLowerCase();
  }

  private boolean checkName(String name) {
    return name.contains(" ");
  }

  private void setEmail(String name) {
    int i = name.indexOf(" ");
    email =
        name.substring(0, i).toLowerCase()
            + "."
            + name.substring(i + 1).toLowerCase()
            + "@oracleacademy.Test";
  }

  /**
   * Checks whether a given password is sufficiently secure.
   *
   * @param password the password the employee is attempting to use
   * @return whether the password is valid
   */
  private boolean isValidPassword(String password) {
    String regex0 = ".*[a-z].*";
    String regex1 = ".*[A-Z].*";
    String regex2 = "[a-zA-Z]*";
    boolean m0 = Pattern.matches(regex0, password);
    boolean m1 = Pattern.matches(regex1, password);
    boolean m2 = !Pattern.matches(regex2, password);
    return m0 && m1 && m2;
  }

  /**
   * Returns the Employee in String form.
   *
   * @return The details of the employee in String form
   */
  @Override
  public String toString() {
    return "Employee Details\nName : "
        + name
        + "\nUsername : "
        + username
        + "\nEmail : "
        + email
        + "\nInitial Password : "
        + password;
  }

  /**
   * Reverses a String using recursion.
   *
   * @param pw The string to be reversed
   * @return The reversed string
   */
  @SuppressWarnings("unused")
  public static String reverseString(String pw) {
    if (pw.length() != 0) {
      char c = pw.charAt(pw.length() - 1);
      return c + reverseString(pw.substring(0, pw.length() - 1));
    }
    return "";
  }

  /**
   * Returns the name of the employee.
   *
   * @return The name of the employee
   */
  public String getName() {
    return name.toString();
  }

  /**
   * Returns the employee's username.
   *
   * @return The employee's username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Checks whether the entered password is correct or not.
   *
   * @param pw The entered password
   * @return Whether or not the entered password is correct
   * @throws DateTimeException Thrown when two incorrect attempts are done within 10 seconds
   */
  public boolean checkPassword(String pw) throws DateTimeException {
    long now = System.nanoTime();
    if (now - lastAttempt < 10000000000L) {
      throw new DateTimeException("");
    }
    if (pw.equals(password)) {
      return true;
    }
    lastAttempt = now;
    return false;
  }

  public String getDeptId() {
    return deptId;
  }

  private void setDeptId(int num) {
    String strNum = "" + num;
    deptId = "000".substring(strNum.length()) + strNum;
  }
}
