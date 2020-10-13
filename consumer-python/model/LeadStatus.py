class LeadStatus:
    def __init__(self):
        pass

    referralId = ""
    leadId = ""
    dealId = ""
    status = ""

    def __str__(self):
        return "LeadStatus{" \
               "referralId='" + self.referralId + \
               ", leadId='" + self.leadId + \
               ", dealId='" + self.dealId + \
               ", status='" + self.status + \
               '}'