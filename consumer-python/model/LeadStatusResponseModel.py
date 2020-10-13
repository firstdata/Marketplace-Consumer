import json
from model import LeadStatus

class LeadStatusResponseModel(object):
    message = ""
    error = []
    leads = [LeadStatus]

    def __init__(self, j):
        self.__dict__ = json.loads(j)

    def __str__(self):
        leads = ''.join(json.dumps(self.leads))
        message = ''.join(json.dumps(self.message))
        error = ''.join(json.dumps(self.error))
        return "LeadHistoryResponse{" \
               "message=" + message + \
               "error=" + error + \
               "leads=" + leads +           \
               '}'
