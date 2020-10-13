import json


class LeadStatusRequest:
    def __init__(self):
        pass

    referralIds = []

    def setReferralIds(self, value):
        self.referralIds = value

    def __str__(self):
        return '{\"referralIds\": ' + json.dumps(self.referralIds) + \
               '}'