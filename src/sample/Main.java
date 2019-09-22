package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Runs a simulated product line. Records items that are added and their attributes. Most recent
 * version is from 9/22/2019. Minor collaboration with Dory Mauretour.
 *
 * @author TomShlomi
 */
public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Product Line");
    primaryStage.setScene(new Scene(root, 600, 550));
    primaryStage.show();
    // establish the database connection
    // display the JOB Data
  } // end method start

  public static void main(String[] args) {
    launch(args);
  } // end method main
} // end class DisplayJobs
