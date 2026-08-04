package ng.myChemo.dtos.requests;

public class DeleteDrugRequest {
    private long drugId;
    private String drugBrand;
    private String drugName;

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public String getDrugBrand() {
        return drugBrand;
    }

    public void setDrugBrand(String drugBrand) {
        this.drugBrand = drugBrand;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugDame(String drugName) {
        this.drugName = drugName;
    }
}
