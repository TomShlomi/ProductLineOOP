package tomsh;

import java.util.Date;

/**
 * Represents an object capable of playing sound.
 *
 * @author TomShlomi
 */
public class AudioPlayer extends Product implements MultimediaControl {
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * Constructor.
   *
   * @param name the item's name
   * @param manufacturer its manufacturer
   * @param audioFormats the audio formats it supports
   * @param playlistFormats the playlist formats it supports
   */
  public AudioPlayer(
      String name, String manufacturer, String audioFormats, String playlistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    supportedAudioFormats = audioFormats;
    supportedPlaylistFormats = playlistFormats;
  }

  /**
   * Default constructor.
   *
   * @param n name
   * @param m manufacturer
   */
  @SuppressWarnings("unused")
  public AudioPlayer(String n, String m) {
    super(n, "OracleProduction", ItemType.AUDIO);
    supportedAudioFormats = m;
  }

  @Override
  public String toString() {
    return "Manufacturer: "
        + getManufacturer()
        + "\nDate : "
        + new Date()
        + "\nName: "
        + getName()
        + "\nAudio Spec : "
        + supportedAudioFormats
        + "\nPlaylist Spec : "
        + supportedPlaylistFormats
        + "\nType: "
        + getType().toString();
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }
}
