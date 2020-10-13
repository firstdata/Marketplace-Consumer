package consumer.model.lead.history;

import java.util.List;

public class LeadHistoryModel {
    private String leadId;
    private String dealId;
    private List<LeadHistory> applicationHistory;

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

    public List<LeadHistory> getApplicationHistory() {
        return applicationHistory;
    }

    public void setApplicationHistory(List<LeadHistory> applicationHistory) {
        this.applicationHistory = applicationHistory;
    }

    @Override
    public String toString() {
        return "LeadHistoryModel{" +
                "leadId='" + leadId + '\'' +
                ", dealId='" + dealId + '\'' +
                ", applicationHistory=" + applicationHistory +
                '}';
    }
}
