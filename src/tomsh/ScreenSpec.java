package tomsh;

/**
 * Interface that defines variables for screens.
 *
 * @author TomSh
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
