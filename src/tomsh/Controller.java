package tomsh;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;

/**
 * Controller for fxml.
 *
 * @author TomShlomi
 */
@SuppressWarnings("WeakerAccess")
public class Controller {

  ObservableList productline;

  @FXML
  // Initializes GUI.
  public void initialize() {
    initializeComboBox();
    initializeChoiceBox();
  }

  @FXML private TableView<Product> tbv_existing_products;
  @FXML private TextField txt_product_text;
  @FXML private TextField txt_manufacturer_text;
  @FXML private ChoiceBox<String> cbx_item_type;
  @FXML private ComboBox<Integer> cmb_choose_quantity;
  @FXML private TextArea production_log_text;
  @FXML private ListView<Product> lvw_choose_product;

  private int productionNumber = 0;
  private int num = 0;

  @FXML
  // Occurs when button clicked.
  protected void productLineButtonAction(ActionEvent event) {
    ObservableList<Product> data = tbv_existing_products.getItems();
    Widget w =
        new Widget(
            txt_product_text.getText(),
            txt_manufacturer_text.getText(),
            ItemType.getType(cbx_item_type.getValue()));
    data.add(w);
    lvw_choose_product.getItems().add(w);
    w.setId(num);
    num++;
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
    System.out.println(lvw_choose_product.getSelectionModel().getSelectedIndex());
    Product w = lvw_choose_product.getItems().get(lvw_choose_product.getSelectionModel().getSelectedIndex());
    ProductionRecord prodRec =   new ProductionRecord(w, num);
    prodRec.setProductionNum(productionNumber++);
    production_log_text.appendText(
            "\n" + prodRec.toString());
    productionNumber++;
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
    for (ItemType it : ItemType.values()) {
      data.add(it.getName());
    }
  }
}
