package tomsh;

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIOMOBILE("AM"),
  VISUALMOBILE("VM");

  private String name;

  ItemType(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public static ItemType getType(String name) {
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
    return null;
  }
}
