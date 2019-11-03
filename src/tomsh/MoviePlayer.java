package tomsh;

public class MoviePlayer extends Product implements MultimediaControl {
  private Screen screen;

  private MonitorType monitorType;

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

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
