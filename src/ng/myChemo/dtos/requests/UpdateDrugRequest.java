package ng.myChemo.dtos.requests;

import java.math.BigDecimal;

public class UpdateDrugRequest {

    private long drugId;
    private String drugName;
    private String drugBrand;
    private BigDecimal sellingPrice;
    private long quantity;


    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugBrand() {
        return drugBrand;
    }

    public void setDrugBrand(String drugBrand) {
        this.drugBrand = drugBrand;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
