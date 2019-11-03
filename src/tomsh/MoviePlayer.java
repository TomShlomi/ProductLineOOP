package tomsh;

/**
 * Represents a movie player.
 *
 * @author TomSh
 */
public class MoviePlayer extends Product implements MultimediaControl {
  @SuppressWarnings({"FieldCanBeLocal", "unused"})
  private final Screen screen;

  @SuppressWarnings({"FieldCanBeLocal", "unused"})
  private final MonitorType monitorType;

  /**
   * Constructor, manually sets all variables except type, which is set to VISUAL.
   *
   * @param name the item's name
   * @param manufacturer its manufacturer
   * @param screen the Screen object associated with it
   * @param monitorType the MonitorType associated with it
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType().toString()
        + "\nScreen:\nResolution: 720x480\n"
        + "Refresh rate: 40\n"
        + "Response time: 22\n"
        + "Monitor Type: "
        + getType();
  }

  public void play() {
    System.out.println("Playing movie");
  }

  public void stop() {
    System.out.println("Stopping movie");
  }

  public void next() {
    System.out.println("Next movie");
  }

  public void previous() {
    System.out.println("Previous movie");
  }
}
