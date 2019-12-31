package consumer.common;

public enum ConsumerConstants {

    LeadsStatusUrl("http://localhost:8080/api/leads/status");

    private final String url;

    ConsumerConstants(String url) {
        this.url = url;
    }

}
