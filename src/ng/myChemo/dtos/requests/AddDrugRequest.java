package ng.myChemo.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddDrugRequest {
    private BigDecimal price;
    private String drugName;
    private String brand;
    private int quantity;
    private LocalDate expiryDate;
    private String chemistName;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getChemistName() {
        return chemistName;
    }

    public void setChemistName(String chemistName) {
        this.chemistName = chemistName;
    }

}
