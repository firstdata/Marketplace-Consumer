package consumer.model.Request;

import java.util.List;

public class LeadHistoryDetailsRequest {

    List<String> referralIds;

    public List<String> getReferralIds() {
        return referralIds;
    }

    public void setReferralIds(List<String> referralIds) {
        this.referralIds = referralIds;
    }

    @Override
    public String toString() {
        return "LeadHistoryDetailsResponse{" +
                "hashedReferralId='" + referralIds + '\'' +
                '}';
    }
}
