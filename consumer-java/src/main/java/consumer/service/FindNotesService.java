package consumer.service;
import consumer.model.Request.LeadHistoryRequest;
import org.springframework.stereotype.Service;

@Service
public class FindNotesService {

    public String leadResponse(LeadHistoryRequest request)
    {
        return "Success";
    }
}
