package ng.myChemo.dtos.requests;

import java.time.LocalDateTime;
import java.util.List;

public class DispenseDrugsRequest {

    private String dispensedBy;
    private List<DispenseDrugsRequest> dispenseDrugsRequests;
    private LocalDateTime dispensedDateTime;

    public String getDispensedBy() {
        return dispensedBy;
    }

    public void setDispensedBy(String dispensedBy) {
        this.dispensedBy = dispensedBy;
    }

    public List<DispenseDrugsRequest> getDispenseDrugsRequests() {
        return dispenseDrugsRequests;
    }

    public void setDispenseDrugsRequests(List<DispenseDrugsRequest> dispenseDrugsRequests) {
        this.dispenseDrugsRequests = dispenseDrugsRequests;
    }

    public LocalDateTime getDispensedDateTime() {
        return dispensedDateTime;
    }

    public void setDispensedDateTime(LocalDateTime dispensedDateTime) {
        this.dispensedDateTime = dispensedDateTime;
    }
}
