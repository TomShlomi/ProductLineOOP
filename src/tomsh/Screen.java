package tomsh;

/**
 * Represents a screen.
 *
 * @author TomSh
 */
public class Screen implements ScreenSpec {
  private final String resolution;
  private final int refreshRate;
  private final int responseTime;

  /**
   * Constructor.
   *
   * @param resolution the object's resolution
   * @param refreshRate its refresh rate
   * @param responseTime its response time
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  @Override
  public String toString() {
    return "Resolution: "
        + resolution
        + "\nRefresh Rate: "
        + refreshRate
        + "\nResponse Time: "
        + responseTime;
  }

  @SuppressWarnings("unused")
  @Override
  public String getResolution() {
    return resolution;
  }

  @SuppressWarnings("unused")
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @SuppressWarnings("unused")
  @Override
  public int getResponseTime() {
    return responseTime;
  }
}
