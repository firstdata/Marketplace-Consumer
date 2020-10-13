package consumer.common;

import java.text.SimpleDateFormat;

public class ConsumerConstants {
    public static final String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    public static final String api_key = "apikey";
    public static final String api_secret = "apisecret";

    public static final String NONCE = "nonce";
    public static final String APIKEY = "apikey";
    public static final String APISECRET = "pzsecret";
    public static final String TOKEN = "token";
    public static final String TIMESTAMP = "timestamp";
    public static final String AUTHORIZE = "authorization";
    public static final String PAYLOAD = "payload";
    public static final String OUTH_AUTHORIZATION_KEY = "Bearer OAUTHKEY";
}
