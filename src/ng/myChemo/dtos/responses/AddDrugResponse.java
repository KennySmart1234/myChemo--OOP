package ng.myChemo.dtos.responses;

public class AddDrugResponse {

    private String brand;
    private long totalDrugsAvailable;
    private String drugName;
    private long totalDrugsAdded;
    private long totalDrugAdded;
    private long batchId;
    private long drugId;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getTotalDrugsAvailable() {
        return totalDrugsAvailable;
    }

    public void setTotalDrugsAvailable(long totalDrugsAvailable) {
        this.totalDrugsAvailable = totalDrugsAvailable;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public long getTotalDrugsAdded() {
        return totalDrugsAdded;
    }

    public void setTotalDrugsAdded(long totalDrugsAdded) {
        this.totalDrugsAdded = totalDrugsAdded;
    }

    public long getTotalDrugAdded() {
        return totalDrugAdded;
    }

    public void setTotalDrugAdded(long totalDrugAdded) {
        this.totalDrugAdded = totalDrugAdded;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }
}
