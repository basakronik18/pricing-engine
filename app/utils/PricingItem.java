package utils;

public class PricingItem {

  private String itemDescription;
  private String itemCategory; //Like book, toys
  private String itemSubCategory; //Like technical-book, story-book, racing-car toys, robot toys
  private String brand; //Like pearson for books, hot-wheels for toys
  private Integer yearOfPurchase;
  private Double costOfPurchase;
  private Double itemHealth; //Will be a fraction based upon how much the book is torn, marked. or a toy is damaged
                            //PricingItem-Health could be determined based upon user-input while uploading, will be an item-level
                            // attribute


  public PricingItem() {
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getItemCategory() {
    return itemCategory;
  }

  public void setItemCategory(String itemCategory) {
    this.itemCategory = itemCategory;
  }

  public String getItemSubCategory() {
    return itemSubCategory;
  }

  public void setItemSubCategory(String itemSubCategory) {
    this.itemSubCategory = itemSubCategory;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getYearOfPurchase() {
    return yearOfPurchase;
  }

  public void setYearOfPurchase(Integer yearOfPurchase) {
    this.yearOfPurchase = yearOfPurchase;
  }

  public Double getCostOfPurchase() {
    return costOfPurchase;
  }

  public void setCostOfPurchase(Double costOfPurchase) {
    this.costOfPurchase = costOfPurchase;
  }

  public Double getItemHealth() {
    return itemHealth!=null ? itemHealth : 0.75;
  }

  public void setItemHealth(Double itemHealth) {
    this.itemHealth = itemHealth;
  }
}
