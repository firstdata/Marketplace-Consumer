package consumer.model.Response;

import consumer.model.LeadStatus;

import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter @Setter
public class LeadHistoryDetailsResponse {

        private List<LeadStatus> leadStatus;

        @Override
        public String toString() {
            return "LeadHistoryResponse{" +
                    "leadStatus=" + leadStatus +
                    '}';
        }
}


