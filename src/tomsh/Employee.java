package tomsh;

import java.util.regex.Pattern;

public class Employee {
    private StringBuilder name;
    private String username;
    private String password;
    private String email;

    public Employee(String name, String password) {
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
            this.password = "pw";
        }
    }

    private void setUsername(String name) {
        username = "" + name.charAt(0);
        username += name.substring(name.indexOf(" ") + 1);
        username = username.toLowerCase();
    }

    private boolean checkName(String name) {
        if (name.indexOf(" ") == -1) {
            return false;
        }
        return true;
    }

    private void setEmail(String name) {
        int i = name.indexOf(" ");
        email = name.substring(0, i).toLowerCase() + "." + name.substring(i + 1).toLowerCase() + "@oracleacademy.Test";
    }

    private boolean isValidPassword(String password) {
        String regex0 = ".*[a-z].*";
        String regex1 = ".*[A-Z].*";
        String regex2 = "[a-zA-Z]*";
        boolean m0 = Pattern.matches(regex0, password);
        boolean m1 = Pattern.matches(regex1, password);
        boolean m2 = !Pattern.matches(regex2, password);
        return m0 && m1 && m2;
    }

    @Override
    public String toString() {
        String s = "Employee Details\nName : " + name
                + "\nUsername : " + username
                + "\nEmail : " + email
                + "\nInitial Password : " + password;
        return s;
    }
}
