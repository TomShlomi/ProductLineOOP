package tomsh;

public abstract class Product implements Item {
  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type.toString();
  }

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

  public void setType(ItemType type) {
    this.type = type;
  }

  public ItemType getType() {
    return type;
  }
}

class Widget extends Product {
  public Widget(String n, String m, ItemType t) {
    super(n, m, t);
  }

  public void play() {}

  public void stop() {}

  public void next() {}

  public void previous() {}
}
