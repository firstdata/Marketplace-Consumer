package consumer.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class LeadHistory {

    private String status;
    private String createdBy;
    private String date;
    private String comment;

    private String action;

    @Override
    public String toString() {
        return "LeadHistory{" +
                "status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", date='" + date + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
