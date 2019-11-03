package tomsh;

@SuppressWarnings("SpellCheckingInspection")
public enum ItemType {
  NULL(""),
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIOMOBILE("AM"),
  VISUALMOBILE("VM");

  private final String name;

  ItemType(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  /**
   * Returns the ItemType object corresponding to a given name.
   *
   * @param name the inputted name
   * @return the corresponding object
   */
  public static ItemType getType(String name) {
    if (name == null) {
      return NULL;
    }
    if (name.equals("AU")) {
      return AUDIO;
    }
    if (name.equals("VI")) {
      return VISUAL;
    }
    if (name.equals("AM")) {
      return AUDIOMOBILE;
    }
    if (name.equals("VM")) {
      return VISUALMOBILE;
    }
    return NULL;
  }
}
