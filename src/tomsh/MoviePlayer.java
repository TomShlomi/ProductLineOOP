package tomsh;

import java.util.Date;

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

  /**
   * Generates a movie player based upon its name, screen, and monitor type.
   *
   * @param name the name of the MoviePlayer
   * @param screen the MoviePlayer's Screen
   * @param monitorType the type of monitor it uses
   */
  public MoviePlayer(String name, Screen screen, MonitorType monitorType) {
    super(name, "OracleProduction", ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public String toString() {
    return "Manufacturer: "
        + getManufacturer()
        + "\nDate : "
        + new Date()
        + "\nName: "
        + getName()
        + "\nType: "
        + getType().toString()
        + "\nScreen: Resolution: "
        + screen.getResolution()
        + "\nRefresh rate: 40\n"
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
