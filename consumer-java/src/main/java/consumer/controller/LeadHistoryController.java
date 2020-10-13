package consumer.controller;

import consumer.model.BaseModel;
import consumer.model.BaseResponseModel;
import consumer.model.lead.history.LeadHistoryModel;
import consumer.service.TriggerEndPoint;
import consumer.service.ValidateSecureEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/v1")
@RestController
public class LeadHistoryController {

    TriggerEndPoint triggerEndPoint;
    ValidateSecureEndPoint validateSecureEndPoint;

    @Autowired
    public LeadHistoryController(TriggerEndPoint triggerEndPoint, ValidateSecureEndPoint validateSecureEndPoint) {
        this.triggerEndPoint = triggerEndPoint;
        this.validateSecureEndPoint = validateSecureEndPoint;
    }

    @RequestMapping(path = "/lead/history/endpoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseModel getLeadHistory(@RequestBody LeadHistoryModel request) {
        BaseModel response = new BaseModel();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("success");
        return response;
    }

    @RequestMapping(path = "/trigger/lead/history/endpoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseModel triggerLeadHistoryEndPoint(@RequestBody BaseResponseModel request) {
        return triggerEndPoint.triggerLeadHistoryEndPoint();
    }

    @RequestMapping(path = "/hmac/lead/history/endpoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getLeadHistoryHMACEndpoint(@RequestBody LeadHistoryModel request, @RequestHeader Map<String, String> headers) {
        return validateSecureEndPoint.validateHMACLeadHistoryEndPoint(request, headers);
    }

    @RequestMapping(path = "/trigger/hmac/lead/history/endpoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseModel triggerLeadHistoryHMACEndPoint(@RequestBody BaseResponseModel request) {
        return triggerEndPoint.triggerHMACLeadHistoryEndPoint();
    }

    @RequestMapping(path = "/oauth/lead/history/endpoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getLeadHistoryOAUTHEndpoint(@RequestBody LeadHistoryModel request, @RequestHeader Map<String, String> headers) {
        return validateSecureEndPoint.validateOAUTHLeadHistoryEndPoint(request, headers);
    }

    @RequestMapping(path = "/trigger/oauth/lead/history/endpoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseModel triggerLeadHistoryOAUTHEndPoint(@RequestBody BaseResponseModel request) {
        return triggerEndPoint.triggerOAUTHLeadHistoryEndPoint();
    }
}
