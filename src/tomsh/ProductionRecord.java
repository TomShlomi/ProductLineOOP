package tomsh;

import java.util.Date;

/**
 * Records the production of a product.
 *
 * @author TomSh
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;
  private Product prod;
  private Employee employee;

  /**
   * Constructor, initializes all values.
   *
   * @param productID Product id
   */
  @SuppressWarnings("unused")
  public ProductionRecord(int productID) {
    productionNumber = 0;
    this.productID = productID;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Constructor, manually sets all values.
   *
   * @param productionNumber the production number
   * @param productID the product ID
   * @param serialNumber the serial number
   * @param date the date created
   */
  @SuppressWarnings("unused")
  public ProductionRecord(int productionNumber, int productID, String serialNumber, Date date) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    dateProduced = new Date(date.getTime());
  }

  /**
   * Constructor, uses a product to automatically generate a serial number.
   *
   * @param prod a Product Object
   * @param num the number of those objects create
   */
  public ProductionRecord(Product prod, Employee e, int num) {
    String strNum = "" + num;
    strNum = "00000".substring(strNum.length()) + strNum;
    serialNumber =
        (prod.getManufacturer() + "   ").substring(0, 3).trim() + prod.getType().getName() + strNum;
    dateProduced = new Date();
    productID = prod.getId();
    this.prod = prod;
    employee = e;
  }

  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product Name: "
        + prod.getName()
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced
        + " Employee ID: "
        + employee.getDeptId();
  }

  @SuppressWarnings("unused")
  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductionNum(int productionNum) {
    productionNumber = productionNum;
  }

  @SuppressWarnings("unused")
  public int getProductID() {
    return productID;
  }

  @SuppressWarnings("unused")
  public void setProductID(int productID) {
    this.productID = productID;
  }

  @SuppressWarnings("unused")
  public String getSerialNum() {
    return serialNumber;
  }

  @SuppressWarnings("unused")
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  @SuppressWarnings("unused")
  public Date getProdDate() {
    return new Date(dateProduced.getTime());
  }

  @SuppressWarnings("unused")
  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }
}
