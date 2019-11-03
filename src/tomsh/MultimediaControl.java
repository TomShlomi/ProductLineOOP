package tomsh;

/**
 * Interface for devices capable of playing media.
 *
 * @author TomSh
 */
@SuppressWarnings("WeakerAccess")
public interface MultimediaControl {
  void play();

  void stop();

  void next();

  void previous();
}
