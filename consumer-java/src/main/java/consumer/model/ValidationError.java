package consumer.model;

public class ValidationError {
    private String errorType;
    private String errorCode;
    private String location;
    private String errorMessage;

    public ValidationError() {
    }

    public ValidationError(String errorType, String errorCode, String location, String errorMessage) {
        setErrorType(errorType);
        setErrorCode(errorCode);
        setLocation(location);
        setErrorMessage(errorMessage);
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "errorType='" + getErrorType() + '\'' +
                ", errorCode='" + getErrorCode() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
