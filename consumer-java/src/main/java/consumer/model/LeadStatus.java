package consumer.model;

import lombok.*;

@Getter @Setter
public class LeadStatus {

    private String referralId;
    private String leadId;
    private String dealId;
    private String status;

    @Override
    public String toString() {
        return "LeadStatus{" +
                "referralId='" + referralId + '\'' +
                ", leadId='" + leadId + '\'' +
                ", dealId='" + dealId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
