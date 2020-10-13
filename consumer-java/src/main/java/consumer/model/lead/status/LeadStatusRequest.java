package consumer.model.lead.status;

import java.util.List;

public class LeadStatusRequest {
    List<String> referralIds;

    public List<String> getReferralIds() {
        return referralIds;
    }

    public void setReferralIds(List<String> referralIds) {
        this.referralIds = referralIds;
    }
}
