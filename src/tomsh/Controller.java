package tomsh;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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

  @FXML private TableView<Product> tbvExistingProducts;
  @FXML private TextField txtProductText;
  @FXML private TextField txtManufacturerText;
  @FXML private ChoiceBox<String> cbxItemType;
  @FXML private ComboBox<Integer> cmbChooseQuantity;
  @FXML private TextArea productionLogText;
  @FXML private ListView<Product> lvwChooseProduct;

  private int productionNumber = 0;
  private int num = 0;

  @FXML
  // Occurs when button clicked.
  protected void productLineButtonAction(ActionEvent event) {
    ObservableList<Product> data = tbvExistingProducts.getItems();
    Widget w =
        new Widget(
            txtProductText.getText(),
            txtManufacturerText.getText(),
            ItemType.getType(cbxItemType.getValue()));
    data.add(w);
    lvwChooseProduct.getItems().add(w);
    w.setId(num);
    num++;
  }

  @FXML
  // Initializes ComboBox with integers 1-10.
  protected void initializeComboBox() {
    ObservableList<Integer> data = cmbChooseQuantity.getItems();
    for (int i = 1; i <= 10; i++) {
      data.add(i);
    }
    cmbChooseQuantity.getSelectionModel().selectFirst();
    cmbChooseQuantity.setEditable(true);
  }

  @FXML
  // Occurs when Record Production button clicked.
  protected void recordProductionButtonAction(ActionEvent event) {
    Product w =
        lvwChooseProduct.getItems().get(lvwChooseProduct.getSelectionModel().getSelectedIndex());
    ProductionRecord prodRec = new ProductionRecord(w, num);
    prodRec.setProductionNum(productionNumber++);
    productionLogText.appendText("\n" + prodRec.toString());
    productionNumber++;
  }

  /**
   * Initializes the ChoiceBox.
   *
   * <p>Includes the types of items.
   */
  @FXML
  public void initializeChoiceBox() {
    ObservableList<String> data = cbxItemType.getItems();
    data.clear();
    for (ItemType it : ItemType.values()) {
      data.add(it.getName());
    }
  }
}
