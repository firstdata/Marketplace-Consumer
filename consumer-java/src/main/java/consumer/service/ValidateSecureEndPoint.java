package consumer.service;

import consumer.common.CommonUtil;
import consumer.common.ConsumerConstants;
import consumer.model.BaseModel;
import consumer.model.lead.history.LeadHistoryModel;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class ValidateSecureEndPoint {

    public ResponseEntity validateHMACLeadHistoryEndPoint(LeadHistoryModel response, Map<String, String> headers) {
        try {
            String timestamp = headers.get(ConsumerConstants.TIMESTAMP) != null ? headers.get(ConsumerConstants.TIMESTAMP) : null;
            String nonce = headers.get(ConsumerConstants.NONCE) != null ? headers.get(ConsumerConstants.NONCE) : null;
            String apikey = headers.get(ConsumerConstants.APIKEY) != null ? headers.get(ConsumerConstants.APIKEY) : null;
            String apisecret = headers.get(ConsumerConstants.APISECRET) != null ? headers.get(ConsumerConstants.APISECRET) : null;
            String authorization = headers.get(ConsumerConstants.AUTHORIZE) != null ? headers.get(ConsumerConstants.AUTHORIZE) : null;

            String payload = CommonUtil.encodeBase64(response.toString(),
                    MessageDigestAlgorithms.MD5,
                    StandardCharsets.US_ASCII.toString());

            String newAuthorization = "hmac " + ConsumerConstants.api_key + ":" +
                                                CommonUtil.getHmacToken(timestamp, ConsumerConstants.api_key, ConsumerConstants.api_secret, payload, nonce) + ":" +
                                                nonce + ":" +
                                                timestamp;
            if(newAuthorization.equalsIgnoreCase(authorization) &&
                    ConsumerConstants.api_key.equalsIgnoreCase(apikey) &&
                    ConsumerConstants.api_secret.equalsIgnoreCase(apisecret)) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity validateOAUTHLeadHistoryEndPoint(LeadHistoryModel response, Map<String, String> headers) {
        try {
            String authorization = headers.get(ConsumerConstants.AUTHORIZE) != null ? headers.get(ConsumerConstants.AUTHORIZE) : null;

            if(ConsumerConstants.OUTH_AUTHORIZATION_KEY.equalsIgnoreCase(authorization)) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
