package consumer.service;

import consumer.common.ConsumerConstants;
import consumer.model.Request.LeadHistoryDetailsRequest;
import consumer.model.Response.LeadHistoryDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VerifyLeadHistoryResponse {

    RestTemplate restTemplate;

    @Autowired
    public VerifyLeadHistoryResponse(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int verifyLeadHistoryDetails(LeadHistoryDetailsRequest request)
    {
        String url = "http://localhost:8080/api/v1/leads/status1";
        try {
            LeadHistoryDetailsResponse leadHistoryDetailsResponse = restTemplate.postForObject(url, request, LeadHistoryDetailsResponse.class);
            if (Objects.nonNull(leadHistoryDetailsResponse)) {
                return HttpStatus.OK.value();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST.value();
    }
}
