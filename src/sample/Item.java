package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Mostly just some getters and setters for sample.fxml.
 *
 * @author TomShlomi
 */
@SuppressWarnings("WeakerAccess")
public class Item {
  private final SimpleStringProperty name = new SimpleStringProperty("");
  private final SimpleStringProperty manufacturer = new SimpleStringProperty("");
  private final SimpleStringProperty type = new SimpleStringProperty("");

  public Item() {
    this("", "", "");
  }

  /**
   * Initializes Item.
   *
   * @param n number
   * @param m manufacturer
   * @param t type
   */
  public Item(String n, String m, String t) {
    setName(n);
    setManufacturer(m);
    setType(t);
  }

  public String getName() {
    return name.get();
  }

  @SuppressWarnings("WeakerAccess")
  public void setName(String n) {
    name.set(n);
  }

  public String getManufacturer() {
    return manufacturer.get();
  }

  public void setManufacturer(String m) {
    manufacturer.set(m);
  }

  public String getType() {
    return type.get();
  }

  public void setType(String t) {
    type.set(t);
  }
}
