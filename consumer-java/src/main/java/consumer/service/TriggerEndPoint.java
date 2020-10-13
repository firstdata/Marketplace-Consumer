package consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.common.CommonUtil;
import consumer.common.ConsumerConstants;
import consumer.model.BaseModel;
import consumer.model.lead.history.LeadHistoryModel;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class TriggerEndPoint {

    RestTemplate restTemplate;

    @Autowired
    public TriggerEndPoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BaseModel triggerLeadHistoryEndPoint() {
        String url = "http://localhost:9000/v1/lead/history/endpoint";
        BaseModel response = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LeadHistoryModel request  = objectMapper.readValue(new ClassPathResource("json/LeadHistoryResponse.json").getInputStream(),
                    LeadHistoryModel.class);

            response = restTemplate.postForObject(url, request, BaseModel.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new BaseModel();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Trigger Lead History Endpoint failed with error - " + ex.getMessage());
        }
        return response;
    }

    public BaseModel triggerHMACLeadHistoryEndPoint() {
        String url = "http://localhost:9000/v1/hmac/lead/history/endpoint";
        BaseModel response = new BaseModel();
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            LeadHistoryModel request  = objectMapper.readValue(new ClassPathResource("json/LeadHistoryResponse.json").getInputStream(),
                    LeadHistoryModel.class);
            String timestamp = Long.toString(System.currentTimeMillis());
            String apiKey = ConsumerConstants.api_key;
            String apiSecret = ConsumerConstants.api_secret;
            String nonce = CommonUtil.getNonce();
            String payload = CommonUtil.encodeBase64(request.toString(),
                                        MessageDigestAlgorithms.MD5,
                                        StandardCharsets.US_ASCII.toString());

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(ConsumerConstants.TIMESTAMP, timestamp);
            httpHeaders.add(ConsumerConstants.APIKEY, apiKey);
            httpHeaders.add(ConsumerConstants.APISECRET, apiSecret);
            httpHeaders.add(ConsumerConstants.NONCE, nonce);

            httpHeaders.add(ConsumerConstants.AUTHORIZE,  "hmac " + apiKey + ":" +
                    CommonUtil.getHmacToken(timestamp, apiKey, apiSecret, payload, nonce) + ":" +
                    nonce + ":" +
                    timestamp);

            HttpEntity<LeadHistoryModel> entity = new HttpEntity<>(request ,httpHeaders);
            restTemplate.postForObject(url, entity, ResponseEntity.class);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Success");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Trigger HMAC Lead History Endpoint failed with error - " + ex.getMessage());
        }
        return response;
    }

    public BaseModel triggerOAUTHLeadHistoryEndPoint() {
        String url = "http://localhost:9000/v1/oauth/lead/history/endpoint";
        BaseModel response = new BaseModel();
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            LeadHistoryModel request  = objectMapper.readValue(new ClassPathResource("json/LeadHistoryResponse.json").getInputStream(),
                    LeadHistoryModel.class);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(ConsumerConstants.AUTHORIZE,  ConsumerConstants.OUTH_AUTHORIZATION_KEY);

            HttpEntity<LeadHistoryModel> entity = new HttpEntity<>(request ,httpHeaders);
            restTemplate.postForObject(url, entity, ResponseEntity.class);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Success");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Trigger HMAC Lead History Endpoint failed with error - " + ex.getMessage());
        }
        return response;
    }
}
