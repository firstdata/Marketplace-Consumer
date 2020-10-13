package consumer.model.lead.status;

import consumer.model.BaseModel;

import java.util.List;

public class LeadStatusResponseModel extends BaseModel {
    private List<LeadStatus> leads;

    public List<LeadStatus> getLeads() {
        return leads;
    }

    public void setLeads(List<LeadStatus> leads) {
        this.leads = leads;
    }

    @Override
    public String toString() {
        return "LeadStatusResponseModel{" +
                "leads=" + leads +
                '}';
    }
}
