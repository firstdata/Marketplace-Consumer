package consumer.common;

import org.apache.commons.codec.digest.HmacAlgorithms;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

public class CommonUtil {

    public static String getHmacToken(String timestamp, String apiKey, String apiSecret, String payload, String nonce) throws Exception {
        try {
            String authText = timestamp + apiKey + nonce + payload;

            Mac _mac = Mac.getInstance(HmacAlgorithms.HMAC_SHA_256.toString());

            SecretKeySpec secret_key = new SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(apiSecret.getBytes()),
                    HmacAlgorithms.HMAC_SHA_256.toString());
            _mac.init(secret_key);
            byte[] macHash = _mac.doFinal(authText.getBytes(StandardCharsets.UTF_8.toString()));
            return org.apache.commons.codec.binary.Base64.encodeBase64String(macHash);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public static String getNonce() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return uuidStr.replaceAll("-", "").toLowerCase();
    }

    public static String encodeBase64(String data, String algorithm, String charset) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] dataBytes = digest.digest(data.getBytes(charset));
        return org.apache.commons.codec.binary.Base64.encodeBase64String(dataBytes);
    }

}
