package tomsh;

import java.util.Collection;

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

  @SuppressWarnings("unused")
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

  /**
   * Prints all of the products in a collection that have the same class as prod.
   *
   * @param collection A collection of products
   * @param prod A product. No properties of it are used except its class
   */
  @SuppressWarnings("unused")
  public static void printType(Collection<Product> collection, Product prod) {
    for (Product p : collection) {
      if (prod.getClass() == p.getClass()) {
        System.out.println(p + "\n");
      }
    }
  }

  /**
   * Prints all of the products in a collection with a certain type.
   *
   * @param collection A collection of products
   * @param type The type that will be selected
   */
  @SuppressWarnings("unused")
  public static void printType(Collection<Product> collection, ItemType type) {
    for (Product p : collection) {
      if (p.getType() == type) {
        System.out.println(p + "\n");
      }
    }
  }
}
