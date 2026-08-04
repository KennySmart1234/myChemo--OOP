package ng.myChemo.data.models;

import java.math.BigDecimal;

public class DispensedDrug {
    private BigDecimal totalPrice;
    private Drug drug;
    private long quantity;
    private long dispensedDrugId;
    private long batchId;


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getDispensedDrugId() {
        return dispensedDrugId;
    }

    public void setDispensedDrugId(long dispensedDrugId) {
        this.dispensedDrugId = dispensedDrugId;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }
}
