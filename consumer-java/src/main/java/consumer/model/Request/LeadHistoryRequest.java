package consumer.model.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import consumer.model.LeadHistory;
import java.util.List;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class LeadHistoryRequest {

    private String leadId;
    private String dealId;

    List<LeadHistory> applicationHistory;

    @Override
    public String toString() {
        return "LeadHistoryResponse{" +
                "leadId='" + leadId + '\'' +
                ", dealId='" + dealId + '\'' +
                ", applicationHistory=" + applicationHistory +
                '}';
    }
}
