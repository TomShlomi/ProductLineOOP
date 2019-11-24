package tomsh;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Runs a simulated product line. Records items that are added and their attributes. Most recent
 * version is from 11/23/2019. Minor collaboration with Dory Mauretour.
 *
 * @author TomShlomi
 */
public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionTabs.fxml"));
    primaryStage.setTitle("Product Line");
    primaryStage.setScene(new Scene(root, 600, 550));
    primaryStage.show();
    // establish the database connection
    // display the JOB Data
  } // end method start

  /**
   * Initial arguments.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    launch(args);
    // test constructor used when creating production records from user interface

  } // end method main

  /** Tests some code when the code runs and prints to console. */
  @SuppressWarnings({"SpellCheckingInspection", "unused"})
  private static void testMultimedia() {
    AudioPlayer newAudioProduct =
        new AudioPlayer(
            "DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct =
        new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen, MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }
} // end class DisplayJobs
