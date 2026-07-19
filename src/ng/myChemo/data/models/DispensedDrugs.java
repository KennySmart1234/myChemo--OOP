package ng.myChemo.data.models;

import java.time.LocalDateTime;
import java.util.List;

public class DispensedDrugs {
    private User dispensedBy;
    private List<DispensedDrug> dispensedDrugs;
    private LocalDateTime dispensedDate;
    private int id;


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

    public LocalDateTime getDispensedDate() {

        return dispensedDate;
    }

    public void setDispensedDate(LocalDateTime dispensedDate) {

        this.dispensedDate = dispensedDate;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
