package tomsh;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

  /** Initializes the GUI. */
  @FXML
  public void initialize() {
    initializeComboBox();
    initializeChoiceBox();
    employees = new ArrayList<>();
    productionRecords = new ArrayList<>();
    productionNumbers = new ArrayList<>();
  }

  @FXML private TableView<Product> tbvExistingProducts;
  @FXML private TextField txtProductText;
  @FXML private TextField txtManufacturerText;
  @FXML private ChoiceBox<String> cbxItemType;
  @FXML private ComboBox<String> cmbChooseQuantity;
  @FXML private TextArea productionLogText;
  @FXML private ListView<Product> lvwChooseProduct;
  @FXML private Label lblEmployee;
  @FXML private TextField txtNewName;
  @FXML private TextField txtNewPassword;
  @FXML private TextField txtLoginUsername;
  @FXML private TextField txtLoginPassword;

  private int productionNumber = 0;
  private int employeeNum = 0;
  private ArrayList<Employee> employees;
  private Employee currentEmployee;
  private ArrayList<ProductionRecord> productionRecords;
  private ArrayList<Integer> productionNumbers;

  @FXML
  // Occurs when button clicked.
  protected void productLineButtonAction() {
    ObservableList<Product> data = tbvExistingProducts.getItems();
    String name = txtProductText.getText();
    String manufacturer = txtManufacturerText.getText();
    ItemType type = ItemType.getType(cbxItemType.getValue());
    if (type == null) {
      showAlert(Alert.AlertType.ERROR, "Error", "Please choose an item type.");
      return;
    }
    Widget w = new Widget(name, manufacturer, type);
    data.add(w);
    CompareProducts cp = new CompareProducts();
    data.sort(cp);
    List<Product> listViewProducts = lvwChooseProduct.getItems();
    listViewProducts.add(w);
    listViewProducts.sort(cp);
    productionNumbers.add(0);
  }

  @FXML
  // Initializes ComboBox with integers 1-10.
  protected void initializeComboBox() {
    ObservableList<String> data = cmbChooseQuantity.getItems();
    for (int i = 1; i <= 10; i++) {
      data.add(i + "");
    }
    cmbChooseQuantity.getSelectionModel().selectFirst();
    cmbChooseQuantity.setEditable(true);
  }

  @FXML
  // Occurs when Record Production button clicked.
  protected void recordProductionButtonAction(ActionEvent event) {
    if (currentEmployee == null) {
      showAlert(Alert.AlertType.ERROR, "Error", "Please log in before commencing production.");
      return;
    }
    Product w;
    int prodIndex = lvwChooseProduct.getSelectionModel().getSelectedIndex();
    try {
      w = lvwChooseProduct.getItems().get(prodIndex);
    } catch (IndexOutOfBoundsException e) {
      showAlert(Alert.AlertType.ERROR, "Error", "Please choose a product to manufacture.");
      return;
    }
    int cmbBoxValue;
    try {
      String temp = cmbChooseQuantity.getValue();
      cmbBoxValue = Integer.parseInt(temp);
      if (cmbBoxValue < 0) {
        throw new NumberFormatException();
      }
    } catch (NumberFormatException e) {
      showAlert(
          Alert.AlertType.ERROR,
          "Error",
          "Unfortunately, we do not yet have the metaphysical capacity to make "
              + cmbChooseQuantity.getValue()
              + " "
              + w.getName()
              + "s.");
      return;
    }
    for (int i = 0; i < cmbBoxValue; i++) {
      int num = productionNumbers.get(prodIndex);
      ProductionRecord prodRec = new ProductionRecord(w, currentEmployee, num);
      productionRecords.add(prodRec);
      prodRec.setProductionNum(productionNumber++);
      productionNumbers.set(prodIndex, num + 1);
      productionLogText.appendText("\n" + prodRec.toString());
    }
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

  /** Creates an employee account. */
  @FXML
  public void createAccount() {
    String name = txtNewName.getText();
    String pw = txtNewPassword.getText();
    Employee e;
    try {
      e = new Employee(name, pw, employeeNum);
      employeeNum++;
    } catch (IllegalArgumentException iae) {
      showAlert(
          Alert.AlertType.ERROR,
          "Error",
          "Please type a proper password, including an uppercase letter,"
              + " a lowercase letter, and a special character.");
      return;
    }
    currentEmployee = e;
    employees.add(e);
    lblEmployee.setText(name);
    showAlert(
        Alert.AlertType.INFORMATION, "Account Created", "Your username is " + e.getUsername());
    txtNewName.clear();
    txtNewPassword.clear();
  }

  /** Attempts to login an employee. */
  @FXML
  public void login() {
    for (Employee e : employees) {
      if (txtLoginUsername.getText().equals(e.getUsername())) {
        try {
          if (e.checkPassword(txtLoginPassword.getText())) {
            currentEmployee = e;
            lblEmployee.setText(e.getName());
            txtLoginUsername.clear();
          } else {
            showAlert(
                Alert.AlertType.ERROR,
                "Error",
                "Incorrect password. Please try again in 10 seconds.");
          }
        } catch (DateTimeException dte) {
          showAlert(
              Alert.AlertType.ERROR,
              "Error",
              "Please wait at least 10 seconds between password attempts.");
        }
        txtLoginPassword.clear();
        return;
      }
    }
    txtLoginPassword.clear();
    showAlert(
        Alert.AlertType.ERROR,
        "Error",
        "There is no employee with that username. Please create an account.");
  }

  @FXML
  public void logout() {
    currentEmployee = null;
    lblEmployee.setText("None");
  }

  /** Prints the number of products produced, broken down by type and specific object. */
  @FXML
  public void getStats() {
    String out = "There have been " + productionRecords.size() + " products produced, including:";
    try {
      int num = 0;
      Product w;
      w = lvwChooseProduct.getItems().get(lvwChooseProduct.getSelectionModel().getSelectedIndex());
      for (ProductionRecord pr : productionRecords) {
        if (pr.getProdName().equals(w.getName())) {
          num++;
        }
      }
      out += " " + num + " " + w.getName() + "s, ";
    } catch (IndexOutOfBoundsException ignored) {
      out += " ";
    }
    int aus = 0;
    int ams = 0;
    int vis = 0;
    int vms = 0;
    for (ProductionRecord pr : productionRecords) {
      if (pr.getType() == ItemType.AUDIO) {
        aus++;
      } else if (pr.getType() == ItemType.VISUAL) {
        vis++;
      } else if (pr.getType() == ItemType.AUDIOMOBILE) {
        ams++;
      } else if (pr.getType() == ItemType.VISUALMOBILE) {
        vms++;
      }
    }
    out +=
        aus
            + " audio devices, "
            + vis
            + " visual devices, "
            + ams
            + " audiomobile devices, and "
            + vms
            + " videomobile devices.";
    showAlert(Alert.AlertType.INFORMATION, "Production Statistics", out);
  }

  private void showAlert(Alert.AlertType type, String title, String content) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);

    alert.showAndWait();
  }
}
