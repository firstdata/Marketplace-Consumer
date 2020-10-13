package consumer.model.lead.status;

public class LeadStatus {
    private String leadId;
    private String dealId;
    private String currentStatus;
    private String opportunityId;
    private String referralId;

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    @Override
    public String toString() {
        return "LeadStatus{" +
                "leadId='" + leadId + '\'' +
                ", dealId='" + dealId + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", opportunityId='" + opportunityId + '\'' +
                ", referralId='" + referralId + '\'' +
                '}';
    }
}
