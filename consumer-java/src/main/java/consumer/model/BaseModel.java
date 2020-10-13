package consumer.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel {
    private int status;
    private String message;
    private List<ValidationError> error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ValidationError> getError() {
        return error;
    }

    public void setError(List<ValidationError> error) {
        this.error = error;
    }
}
