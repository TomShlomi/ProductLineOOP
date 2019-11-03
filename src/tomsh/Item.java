package tomsh;

/**
 * Interface for a broad class of items.
 *
 * @author TomSh
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface Item {

  int getId();

  void setName(String n);

  String getName();

  void setManufacturer(String m);

  String getManufacturer();
}
