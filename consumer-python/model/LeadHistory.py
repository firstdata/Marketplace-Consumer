class LeadHistory:
    def __init__(self):
        pass

    status = ""
    createdBy = ""
    date = ""
    comment = ""
    action = ""

    def __str__(self):
        return "LeadHistory{" \
               "status='" + self.status + \
               ", createdBy='" + self.createdBy + \
               ", date='" + self.date + \
               ", comment='" + self.comment + \
               '}'