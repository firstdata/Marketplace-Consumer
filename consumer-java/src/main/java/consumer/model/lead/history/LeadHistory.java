package consumer.model.lead.history;

public class LeadHistory {
    private String status;
    private String createdBy;
    private String date;
    private String comment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

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
