package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller for fxml.
 *
 * @author TomShlomi
 */
@SuppressWarnings("WeakerAccess")
public class Controller {

  @FXML
  // Initializes GUI.
  public void initialize() {
    initializeComboBox();
    initializeChoiceBox();
  }

  @FXML private TableView<Item> tbv_existing_products;
  @FXML private TextField txt_product_text;
  @FXML private TextField txt_manufacturer_text;
  @FXML private ChoiceBox<String> cbx_item_type;
  @FXML private ComboBox<Integer> cmb_choose_quantity;

  @FXML
  // Occurs when button clicked.
  protected void productLineButtonAction(ActionEvent event) {
    // System.out.println("Product Line");
    ObservableList<Item> data = tbv_existing_products.getItems();
    data.add(
        new Item(
            txt_product_text.getText(), txt_manufacturer_text.getText(), cbx_item_type.getValue()));
  }

  @FXML
  // Initializes ComboBox with integers 1-10.
  protected void initializeComboBox() {
    ObservableList<Integer> data = cmb_choose_quantity.getItems();
    for (int i = 1; i <= 10; i++) {
      data.add(i);
    }
    cmb_choose_quantity.getSelectionModel().selectFirst();
    cmb_choose_quantity.setEditable(true);
  }

  @FXML
  // Occurs when Record Production button clicked.
  protected void recordProductionButtonAction(ActionEvent event) {
    System.out.println("Record Production");
  }

  /**
   * Initializes the ChoiceBox.
   *
   * <p>Includes the types of items.
   */
  @FXML
  public void initializeChoiceBox() {
    ObservableList<String> data = cbx_item_type.getItems();
    data.clear();
    data.add("Phone");
    data.add("Desktop");
    data.add("Laptop");
    data.add("Tablet");
  }
}
