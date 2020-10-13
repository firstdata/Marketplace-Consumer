package consumer.controller;

import consumer.model.BaseModel;
import consumer.model.BaseResponseModel;
import consumer.model.lead.history.LeadHistoryModel;
import consumer.model.lead.status.LeadStatusRequest;
import consumer.model.lead.status.LeadStatusResponseModel;
import consumer.service.LeadStatusService;
import consumer.service.TriggerEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/referral")
@RestController
public class LeadStatusController {

    LeadStatusService leadStatusService;

    @Autowired
    public LeadStatusController(LeadStatusService leadStatusService) {
        this.leadStatusService = leadStatusService;
    }

    @RequestMapping(path = "/v1/leads/status", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LeadStatusResponseModel getLeadStatus(@RequestBody LeadStatusRequest request) {
        return leadStatusService.processLeadStatus(request);
    }

    @RequestMapping(path = "/v1/consumer/trigger/leads/status", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseModel triggerLeadsStatus(@RequestBody BaseResponseModel request) {
        return leadStatusService.triggerLeadsStatus();
    }
}
