package ng.myChemo.data.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class Batch {

    private long drugId;
    private long batchId;
    private long purchaseQuantity;
    private long quantityLeft;
    private LocalDate purchaseDate;
    private YearMonth expiryDate;
    private BigDecimal costPrice;

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public long getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(long quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(YearMonth expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
