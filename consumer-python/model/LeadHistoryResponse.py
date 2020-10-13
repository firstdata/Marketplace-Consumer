import json
from model import LeadHistory


class LeadHistoryResponse:
    def __init__(self, j):
        self.__dict__ = json.loads(j)

    leadId = ""
    dealId = ""

    applicationHistory = [LeadHistory]

    def __str__(self):
        return "LeadHistoryRequest{" \
               "leadId='" + self.leadId + \
               ", dealId='" + self.dealId + \
               ", applicationHistory='" + '\n'.join((str(x) for x in self.applicationHistory)) + \
               '}'
