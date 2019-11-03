package tomsh;

import java.util.Date;

public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  public ProductionRecord(int pID) {
    productionNumber = 0;
    productID = pID;
    serialNumber = "0";
    dateProduced = new Date();
  }

  public ProductionRecord(int pNum, int pID, String sn, Date date) {
    productionNumber = pNum;
    productID = pID;
    serialNumber = sn;
    dateProduced = date;
  }

  public ProductionRecord(Product prod, int num) {
    String strnum = "" + num;
    strnum = "00000".substring(strnum.length()) + strnum;
    serialNumber = (prod.getManufacturer()+"   ").substring(0, 3) + prod.getType().getName() + strnum;
    dateProduced = new Date();
    productID = prod.getId();
  }

  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductionNum(int pNum) {
    productionNumber = pNum;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int pID) {
    productID = pID;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getProdDate() {
    return new Date(dateProduced.getTime());
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }
}
