package ng.myChemo.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class BatchRequest {
    private long quantityPurchased;
    private long quantityLeft;
    private BigDecimal costPrice;
    private YearMonth expiryDate;
    private LocalDate purchasedDate;
    private int drugId;

    public long getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(long quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public long getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(long quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(YearMonth expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
}
