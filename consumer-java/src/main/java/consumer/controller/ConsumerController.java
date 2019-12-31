package consumer.controller;

import consumer.model.Response.LeadHistoryDetailsResponse;
import consumer.model.Request.LeadHistoryDetailsRequest;
import consumer.model.Request.LeadHistoryRequest;
import consumer.service.FindLeadHistoryDetails;
import consumer.service.FindNotesService;
import consumer.service.VerifyLeadHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class ConsumerController {

    FindNotesService findNotes;
    FindLeadHistoryDetails findLeadHistoryDetails;
    VerifyLeadHistoryResponse verifyLeadHistoryResponse;

    @Autowired
    public ConsumerController(FindNotesService findNotes, FindLeadHistoryDetails findLeadHistoryDetails, VerifyLeadHistoryResponse verifyLeadHistoryResponse)
    {
        this.findNotes = findNotes;
        this.findLeadHistoryDetails = findLeadHistoryDetails;
        this.verifyLeadHistoryResponse = verifyLeadHistoryResponse;
    }

    @PostMapping(value = "/v1/consumer/lead/history",consumes = "application/json",produces = "application/json")
    public String getLeadHistory(@RequestBody LeadHistoryRequest request)
    {
        return findNotes.leadResponse(request);
    }

    @PostMapping(value = "/v1/leads/status", consumes = "application/json", produces = "application/json")
    public LeadHistoryDetailsResponse getLeadsStatus(@RequestBody LeadHistoryDetailsRequest request)
    {
        return findLeadHistoryDetails.leadHistoryDetails(request);
    }

    @PostMapping(value = "/v1/consumer/trigger/leads/status", consumes = "application/json", produces = "application/json")
    public int triggerLeadsStatus(@Valid @RequestBody LeadHistoryDetailsRequest request)
    {
        LeadHistoryDetailsRequest referralIds = new LeadHistoryDetailsRequest();
        List<String> referralIdsStr = new ArrayList<>();
        referralIdsStr.add("sab234");
        referralIdsStr.add("aklkljkdl");
        referralIds.setReferralIds(referralIdsStr);
         return verifyLeadHistoryResponse.verifyLeadHistoryDetails(referralIds);
    }
}
