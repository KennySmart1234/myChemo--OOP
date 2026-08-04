package ng.myChemo.data.models;

import java.time.LocalDateTime;
import java.util.List;

public class DispensedDrugs {
    private User dispensedBy;
    private List<DispensedDrug> dispensedDrugs;
    private LocalDateTime dispensedDateTime;
    private long dispensedDrugsId;


    public User getDispensedBy() {
        return dispensedBy;
    }

    public void setDispensedBy(User dispensedBy) {
        this.dispensedBy = dispensedBy;
    }

    public List<DispensedDrug> getDispensedDrugs() {
        return dispensedDrugs;
    }

    public void setDispensedDrugs(List<DispensedDrug> dispensedDrugs) {
        this.dispensedDrugs = dispensedDrugs;
    }

    public LocalDateTime getDispensedDateTime() {
        return dispensedDateTime;
    }

    public void setDispensedDateTime(LocalDateTime dispensedDateTime) {
        this.dispensedDateTime = dispensedDateTime;
    }

    public long getDispensedDrugsId() {
        return dispensedDrugsId;
    }

    public void setDispensedDrugsId(long dispensedDrugsId) {
        this.dispensedDrugsId = dispensedDrugsId;
    }
}
