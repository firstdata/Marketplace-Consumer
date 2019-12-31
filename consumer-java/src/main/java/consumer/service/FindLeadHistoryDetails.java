package consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.model.Response.LeadHistoryDetailsResponse;
import consumer.model.Request.LeadHistoryDetailsRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FindLeadHistoryDetails {

    public LeadHistoryDetailsResponse leadHistoryDetails(LeadHistoryDetailsRequest request)
    {
        ObjectMapper objectMapper = new ObjectMapper();

        LeadHistoryDetailsResponse response = null;
        try {
                response = objectMapper.readValue(new ClassPathResource("json/LeadHistoryResponse.json").getInputStream(), LeadHistoryDetailsResponse.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
