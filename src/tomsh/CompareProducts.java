package tomsh;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("WeakerAccess")
public class CompareProducts implements Comparator<Product>, Serializable {

  @Override
  public int compare(Product o1, Product o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
