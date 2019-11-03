package tomsh;

/**
 * Represents a product.
 *
 * @author TomSh
 */
public abstract class Product implements Item {
  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type.toString();
  }

  /**
   * Constructor, manually sets all variables.
   *
   * @param n name
   * @param m manufacturer
   * @param t type
   */
  @SuppressWarnings("WeakerAccess")
  public Product(String n, String m, ItemType t) {
    setName(n);
    setManufacturer(m);
    setType(t);
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setName(String n) {
    name = n;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setManufacturer(String m) {
    manufacturer = m;
  }

  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  @SuppressWarnings("WeakerAccess")
  public void setType(ItemType type) {
    this.type = type;
  }

  public ItemType getType() {
    return type;
  }
}
