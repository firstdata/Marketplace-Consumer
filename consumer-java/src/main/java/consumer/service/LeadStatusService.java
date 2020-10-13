package consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.model.BaseModel;
import consumer.model.ValidationError;
import consumer.model.lead.status.LeadStatusRequest;
import consumer.model.lead.status.LeadStatusResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadStatusService {
    RestTemplate restTemplate;

    @Autowired
    public LeadStatusService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LeadStatusResponseModel processLeadStatus(LeadStatusRequest request) {
        LeadStatusResponseModel response = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response  = objectMapper.readValue(new ClassPathResource("json/LeadStatusResponse.json").getInputStream(),
                    LeadStatusResponseModel.class);

        } catch (Exception ex) {
            ex.printStackTrace();

            ValidationError validationError = new ValidationError();
            validationError.setErrorType("SYSTEM_ERROR");
            validationError.setErrorMessage("Lead Status service failed with error - " + ex.getMessage());
            List<ValidationError> error = new ArrayList<>();
            error.add(validationError);
            response = new LeadStatusResponseModel();
            response.setError(error);
            response.setMessage("Trigger Lead Status failed with error - " + ex.getMessage());
        }
        return response;
    }

    public BaseModel triggerLeadsStatus() {
        String url = "http://localhost:9000/api/referral/v1/leads/status";
        BaseModel response = new BaseModel();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LeadStatusRequest request  = objectMapper.readValue(new ClassPathResource("json/LeadStatusRequest.json").getInputStream(),
                    LeadStatusRequest.class);

            LeadStatusResponseModel leadStatusResponse = restTemplate.postForObject(url, request, LeadStatusResponseModel.class);
            System.out.println(leadStatusResponse);
            if(leadStatusResponse != null) {
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Success");
            } else {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Failure");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Trigger Lead Status failed with error - " + ex.getMessage());
        }
        return response;
    }

}
