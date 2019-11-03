package tomsh;

public class AudioPlayer extends Product implements MultimediaControl {
  String supportedAudioFormats;
  String supportedPlaylistFormats;

  public AudioPlayer(String name, String manufacturer, String sAF, String sPF) {
    super(name, manufacturer, ItemType.AUDIO);
    supportedAudioFormats = sAF;
    supportedPlaylistFormats = sPF;
  }

  public AudioPlayer(String n, String m, ItemType t) {
    super(n, m, t);
  }

  public AudioPlayer(String n, String m, ItemType t, String q) {
    super(n, m, t);
  }

  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType().toString()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats
        + getType();
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
